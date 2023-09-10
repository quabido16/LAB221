
package doctormanagement;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        Manager manager = new Manager();
        Display display = new Display();

        do {
            display.displayMenu();
            choice = GetData.getAnInteger("Let's select optione: ", "Please enter the integer number", 1, 5);

            switch (choice) {
                case 1:
                    manager.addDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    break;
                case 4:
                    manager.searchDoctor();
                    break;
                case 5:
                    System.out.println("See you next time");

            }
        } while (choice != 5);

    }
}
