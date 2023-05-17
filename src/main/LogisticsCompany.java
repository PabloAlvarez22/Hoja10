package main;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LogisticsCompany {

	public static void main(String[] args) {
		System.out.println("Bienvenido al programa.");
		
		try {
			
            File archivo = new File("C:\\logistica.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Contenido encontrado: ");

            String linea;
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String[] parts = linea.split(" ");
                
            //Agregar al grafo
                
            }
            
            Scanner entrada = new Scanner(System.in);
    		String option = "";
            while (!option.equals("4")) {
    			
    			menu();
    			option = "" + entrada.nextLine();
    			switch (option) {
    			
    			case "1":
    				//Scan ciudad origen
    				//Scan destino
    				//Llamar método calcularRutaCorta
    				break;
    				
    			case "2":
    				//Llamar funcion caclularCentro
    				break;
    				
    			case "3":
    				//Crear menu2
    				//Op1 quitarConexion(ciudad1, ciudad2)
    				//Op2 agregarConexion(Ciudad1, ciudad2) Clima normal
    				//Op3 cambiarClima(clima)
    				break;
    			
    			//Llamar funcion actualizarGrafo
    				
    			}
    			
            }
        }
		
		catch (IOException e) {
            System.out.println("No se ha encontrado el archivo de texto");
            System.out.println("Asegúrese de llamarlo logistica.txt en su disco C");
            return;
        }
     
    }
	
	public static void menu(){
			
			System.out.println("*********************");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Encontrar la ruta más corta entre dos puntos.");
			System.out.println("2. Mostrar centro del grafo");
			System.out.println("3. Modificar grafo");
			System.out.println("4. Salir");
			
		}

}
