/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.jsf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author RICHARD
 */

public class UploadFilesController {
    
    
    private final String pathUpload = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathUpload");
    private final String pathUploadDocu = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathUpload_documento");
    private final String pathUploadFoto = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathUpload_foto");
    private final String pathUploadReso = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathUpload_resolucion");
    private final String pathDownload = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathDownload");
//    private final String pathAppDownload = ResourceBundle.getBundle("/Bundle").getString("Documentos_pathAppDownload");

//    private final String pathUpload = "/opt/glassfish4/glassfish/domains/domain1/applications/NotificacionApp/resources/files/uploads/";
//    private final String pathDownload = "/opt/glassfish4/glassfish/domains/domain1/applications/NotificacionApp/resources/files/downloads/";
//    private final String pathAppDownload = "/resources/files/upload/";
    private StreamedContent file;


    /**
     * @return the file
     */
    public StreamedContent getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public void upload(FileUploadEvent event) {
        System.out.println("SUBIENDO ARCHIVO");
        try {
            copyFileUpload(event.getFile().getFileName(), event.getFile().getInputstream());
            System.out.println("SUBIO CORRECTAMENTE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean upload(UploadedFile file, String newfilename) {
        System.out.println("SUBIENDO ARCHIVO");
        boolean res = false;
        try {
            res = copyFileUpload(newfilename, file.getInputstream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public boolean uploadDocumento(UploadedFile file, String newfilename) {
        System.out.println("SUBIENDO ARCHIVO");
        boolean res = false;
        try {
            res = copyFileUploadDocumento(newfilename, file.getInputstream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public boolean copyFileUpload(String fileName, InputStream in) {
        System.out.println("COPIANDO ARCHIVO");
        boolean res = false;
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(pathUpload + fileName));
            int read = 0;

            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            res = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }

    }

    public boolean copyFileUploadDocumento(String fileName, InputStream in) {
        System.out.println("COPIANDO ARCHIVO");
        boolean res = false;
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(pathUploadDocu + fileName));
            int read = 0;

            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            res = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }

    }

    public boolean uploadFoto(UploadedFile file, String newfilename) {
        System.out.println("SUBIENDO FOTO");
        boolean res = false;
        try {
            res = copyFileUploadFoto(newfilename, file.getInputstream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public boolean copyFileUploadFoto(String fileName, InputStream in) {
        System.out.println("COPIANDO FOTO");
        boolean res = false;
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(pathUploadFoto + fileName));
            int read = 0;

            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            res = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }

    }

    public boolean createCleanDirectory(String folderName) {
        boolean res = false;
        try {
            File dir = new File(pathDownload + folderName);
            if (dir.exists()) {
                FileUtils.cleanDirectory(dir);
                res = true;
            } else {
                if (dir.mkdir()) {
                    res = true;
                }
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }

    public boolean download(String fileNameSource, String fileNameDestino, String folderName) {
        boolean res = false;
        try {
            File source = new File(pathUpload + fileNameSource);
            File directorio = new File(pathDownload + folderName);

//          File dest = new File(directorio + "/" + fileNameDestino);  //PRODUCCION
            File dest = new File(directorio + ResourceBundle.getBundle("/Bundle").getString("Documentos_pathAux") + fileNameDestino);   //DESARROLLO   
            FileUtils.copyFile(source, dest);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

//    public boolean download(String fileNameSource, String fileNameDestino, String folderName) {
//        boolean res = false;
//        try {
//            File source = new File(pathUpload + fileNameSource);
//            File directorio = new File(pathDownload + folderName);
////            if(delete(directorio.getPath(), true))
//            if (directorio.exists()) {
//                FileUtils.cleanDirectory(directorio);
//            } else {
//                if (!directorio.mkdir()) {
//                    return false;
//                }
//            }
////            File dest = new File(directorio + "/" + fileNameDestino);  //PRODUCCION
//            File dest = new File(directorio + ResourceBundle.getBundle("/Bundle").getString("Documentos_pathAux") + fileNameDestino);   //DESARROLLO   
//            FileUtils.copyFile(source, dest);
//            res = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            return res;
//        }
//    }
//    public boolean delete(String filePath, boolean recursive) {
//        File file = new File(filePath);
//        if (!file.exists()) {
//            return true;
//        }
//
//        if (!recursive || !file.isDirectory()) {
//            return file.delete();
//        }
//
//        String[] list = file.list();
//        for (int i = 0; i < list.length; i++) {
//            if (!delete(filePath + File.separator + list[i], true)) {
//                return false;
//            }
//        }
//        return file.delete();
//    }
    public void FileDownload(String fileName) {
        try {
            InputStream stream = new FileInputStream(pathUploadDocu + fileName);
            //InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(pathAppDownload + fileName);
            file = new DefaultStreamedContent(stream, "application/pdf", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StreamedContent FotoDownload(String fileName) {
        try {
            StreamedContent fotoFile;
            InputStream stream = new FileInputStream(pathUploadFoto + fileName);
            //InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(pathAppDownload + fileName);
            fotoFile = new DefaultStreamedContent(stream, "image/jpeg", fileName);
            return fotoFile;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public void PdfDownload(String fileName) throws IOException {
        System.out.println("ingreso al metodo ------------PdfDownload--------------->>>>>>>");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        try {
            InputStream in = new FileInputStream(pathUploadReso + fileName);
            //InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(pathAppDownload + fileName);
            //file = new DefaultStreamedContent(stream,"application/pdf", fileName);

            response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
            response.setContentType("application/pdf"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
            response.setHeader("Content-disposition", "inline; filename=\"" + fileName + "\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.

            BufferedInputStream input = null;
            BufferedOutputStream output = null;

            try {
                input = new BufferedInputStream(in);
                output = new BufferedOutputStream(response.getOutputStream());

                byte[] buffer = new byte[10240];
                for (int length; (length = input.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }
            } catch (Exception e) {
                System.out.println("CATCH PdfDownload");
            } finally {
                System.out.println("FINALLY PdfDownload");
                output.close();
                input.close();
            }
            facesContext.responseComplete(); // Important! Else JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.

        } catch (Exception e) {
            System.out.println("CATCH UploadFilesController PdfDownload");
           // JsfUtil.showRedirectHtmlError("No se encontró el archivo: <font color=\"red\">"+fileName+"</font> en la ruta especificada, debe revisar.");
        }

    }
    
    public boolean verificarJPG(UploadedFile uf) {
        try {
            InputStream i = uf.getInputstream();
            byte[] id = new byte[4];
            if (i.read(id) == 4) {
                if ((id[0] == 0xFF) && (id[1] == 0xD8) && (id[2] == 0xFF) && (id[3] == 0xE0)) {
                    return true;
                }
            }

        } catch (Exception ex) {
            System.out.println("Error:NeDocumentoController:verificarPDF:" + ex.getMessage());
        }
        return false;
    }
    
//    public boolean findFiles(String p_file_name){
//        File[] filesInDirectory = new File(JsfUtil.readBundle("Documentos_pathUpload_resolucion")).listFiles();
//        for (File f : filesInDirectory) {
//            if (f.isFile()) {
//                if (f.getName().equals(p_file_name)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    
}
