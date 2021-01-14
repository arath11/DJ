import java.io.*;

public class getFiles {
    private boolean isFileCreated=false;

    public void getFiles(String path){
        getFilesPrivate(path);
    }

    private void getFilesPrivate(String path){
        String data[];
        String oldData="";
        File rutaArchivo = new File(path);
        if (rutaArchivo.exists()) {
            System.out.println(path);
            File[] archivos = rutaArchivo.listFiles();
            if (!(archivos == null)) {
                for (int i = 0; i < archivos.length; i++) {
                    if (archivos[i].isFile()) {
                        data=archivos[i].getName().split("\\.");
                        try{
                            if(data[1].equals("mp3")|| data[1].equals("mp4") && !data[0].equals(oldData)){
                                //System.out.println(archivos[i].getName());
                                writeToFile(data[0]+","+path);
                                oldData=data[0];
                            }
                        }catch (ArrayIndexOutOfBoundsException | IOException e){

                        }

                        //TODO ADD where to store
                        //System.out.println(archivos[i].getName());
                    } else if (archivos[i].isDirectory()) {
                        getFilesPrivate(archivos[i].getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Esta vacia ");
            }
        } else {
            System.out.println("El directori o la ruta no existeixen.");
        }
    }

    public void writeToFile(String text) throws IOException {
        if(!isFileCreated){
            isFileCreated=!isFileCreated;
            FileWriter writer=new FileWriter("songs.csv");
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write("Nombre,Carpeta\n");
            bufferedWriter.write(text+"\n");
            bufferedWriter.close();
            writer.close();
        }else {
            FileWriter writer=new FileWriter("songs.csv",true);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            PrintWriter pw = new PrintWriter(bufferedWriter);
            pw.write(text+"\n");
            pw.flush();
            pw.close();
            bufferedWriter.close();
            writer.close();
        }

    }


    public static void main(String[] args) {
        getFiles prueba=new getFiles();
        //prueba.getFiles(".//");
        //prueba.getFiles("C:\\Users\\J4\\Desktop");
        prueba.getFiles("C:\\Users\\J4\\Music\\NUEVO S");


    }



}
