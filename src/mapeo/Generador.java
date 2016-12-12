package mapeo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.MapeoErroneoExcepcion;
import Exceptions.ObjetoErroneoExcepcion;

public class Generador {

    private ArrayList objectArray;
    private ClaseATablaMapeador mapeo;
    private ResultSet result;

    public Generador(ClaseATablaMapeador mapeo, ResultSet result) {
        this.mapeo = mapeo;
        this.result = result;
        objectArray = new ArrayList();
    }

    public void buildObjects() throws ObjetoErroneoExcepcion, MapeoErroneoExcepcion, SQLException {
        try {
            Class newClass = Class.forName(mapeo.getNombreClase());
            Object newinstrance = newClass.newInstance();
            while (result.next()) {
                newObject(newinstrance);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new ObjetoErroneoExcepcion("No se puede instanciar el objeto: " + mapeo.getNombreClase());
        }

    }

    private void newObject(Object instance) throws MapeoErroneoExcepcion, ObjetoErroneoExcepcion {

        Field[] classFields = instance.getClass().getDeclaredFields();
        
        //Inicializa cada atributo de la clase
        for (int i = 0; i < classFields.length; i++) {
            String fieldName = mapeo.getCampo(classFields[i].getName());
            if (fieldName != null) {
                initializeFields(fieldName, instance, classFields[i]);
            }
        }

    }

    private void initializeFields(String fieldName, Object object, Field field) throws MapeoErroneoExcepcion, ObjetoErroneoExcepcion {
        
        String methodName = "set" + field.getName();
        Method[] methods = object.getClass().getMethods();
        
        for (int i = 0; i < methods.length; i++) {
            if ((methods[i].getName().toLowerCase()).contains(methodName.toLowerCase())) {
                methodName = methods[i].getName();
                break;
            }
        }

        try {
            String setMethodName = methodName;
            Class[] setMethodParameters = {field.getType()};
            Method setMethod = null;
            setMethod = object.getClass().getDeclaredMethod(setMethodName, setMethodParameters);
            setMethod.invoke(object, result.getObject(fieldName));
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new ObjetoErroneoExcepcion("No se encontro el metodo :" + fieldName);
        } catch (SQLException ex) {
            throw new MapeoErroneoExcepcion("La tabla no contiene : " + fieldName);
        }

    }

    public ArrayList getObjectArray() {
        return objectArray;
    }
}