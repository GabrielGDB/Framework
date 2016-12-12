package mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exceptions.ArchivoConfigPoolNoEncontradoExcepcion;
import Exceptions.MapeoErroneoExcepcion;
import Exceptions.MapeoInexistenteExcepcion;
import Exceptions.ObjetoErroneoExcepcion;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.jdom2.Content.CType.Element;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import pool.PoolConnection;

public class ObjetoRelacionalMap {

    private ArrayList listaObjetos;
    private ClaseATablaMapeador[] mapeos;

    public ObjetoRelacionalMap(String URLArchivoConfiguracion) throws ArchivoConfigPoolNoEncontradoExcepcion, JDOMException {
        obtenerMapeos(URLArchivoConfiguracion);
    }

    private void obtenerMapeos(String URLArchivoConfiguracion) throws ArchivoConfigPoolNoEncontradoExcepcion, JDOMException {
        mapeos = parsear(URLArchivoConfiguracion);
    }

    public void mapearObjetosRelacion(String URLClase, PoolConnection conexion) throws MapeoInexistenteExcepcion, ObjetoErroneoExcepcion, MapeoErroneoExcepcion, SQLException  {

        ClaseATablaMapeador mapeoEncontrado = encontrarMapeo(URLClase);
        
        if (mapeoEncontrado != null) {
            String consulta = "SELECT * FROM " + mapeoEncontrado.getNombreTabla();
            ResultSet datosTabla = conexion.request(consulta);
            
            Generador generador = new Generador(mapeoEncontrado, datosTabla);
            generador.buildObjects();
            listaObjetos = generador.getObjectArray();
        }else{
            throw new MapeoInexistenteExcepcion("Imposible mapear: "+ URLClase);
        }

    }

    private ClaseATablaMapeador encontrarMapeo(String clase) {
        
         for (int j = 0; j < mapeos.length; j++) {

            if ((mapeos[j].getNombreClase()).equals(clase)) {
                return mapeos[j];
            }

        }
        return null;

    }

    public ArrayList getListaObjetos() {
        return listaObjetos;
    }
    
    public ClaseATablaMapeador[] parsear(String ruta) throws ArchivoConfigPoolNoEncontradoExcepcion, JDOMException {
        ClaseATablaMapeador[] configuracion = null ;
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta);
        try {
            Document document = null;
            try {
                document = (Document) builder.build(xmlFile);
            } catch (IOException ex) {
                Logger.getLogger(ObjetoRelacionalMap.class.getName()).log(Level.SEVERE, null, ex);
            }

            Element rootNode = document.getRootElement();

            List<?> list = rootNode.getChildren("class");
            
            configuracion = new ClaseATablaMapeador[list.size()];
            

            for (int numeroMapeo = 0; numeroMapeo < list.size(); numeroMapeo++) {

                Element clase = (Element) list.get(numeroMapeo);
                
                ClaseATablaMapeador nuevoMapeo = new ClaseATablaMapeador();
                
                String nombreClase = clase.getAttributeValue("name");
                nuevoMapeo.setNombreClase(nombreClase);
                
                Element tabla = clase.getChild("table");
                
                String nombreTabla = tabla.getAttributeValue("name");
                nuevoMapeo.setNombreTabla(nombreTabla);
                
                List<?> listaRelaciones = clase.getChildren("relation");
                
            
                for (int numeroRelacion= 0; numeroRelacion < listaRelaciones.size(); numeroRelacion++) {
                    Element relacion = (Element) listaRelaciones.get(numeroRelacion);
                    String nombreAtributo = relacion.getAttributeValue("attribute");
                    String nombreCampo = relacion.getAttributeValue("field");
                    nuevoMapeo.agregar(nombreAtributo, nombreCampo);
                }
                
                configuracion[numeroMapeo] = nuevoMapeo;
            }
        } catch (JDOMException io) {
            throw new ArchivoConfigPoolNoEncontradoExcepcion("No encontrado Archivo de configuracion: "+ ruta);
        }
        
        return configuracion;
    }

}
