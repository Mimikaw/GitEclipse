import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GitEclipse {
	File fa = new File("apellidos.txt");
    File fm = new File ("mujeres.txt");
    File fh = new File ("hombres.txt");

    Scanner sa, sm, sh;

    List<String> la = new ArrayList<>(); //lista de apellidos
    List<String> lm= new ArrayList<>(); // lista de mujeres
    List<String> lh = new ArrayList<>(); // lista de hombres

    PrintWriter ag;

    public GitEclipse()
    {
        /*hay que crear una lista*/

        try
        {
            sa = new Scanner(fa);
            sm = new Scanner(fm);
            sh = new Scanner(fh);
            procesar();
            sh.close();
            sm.close();
            sa.close();

            ag = new PrintWriter("agenda.txt");
            agenda(10);
            ag.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Something went wrong");
        }
    }

    private void procesar()
    {
        while(sa.hasNextLine())
            la.add(sa.nextLine());
        while(sm.hasNextLine())
            lm.add(sm.nextLine());
        while(sh.hasNextLine())
            lh.add(sh.nextLine());
    }

    private void agenda(int n)
    {
        Random r = new Random(21);

        for (int i = 0; i <n; i++)
        {
            String persona = "";

            if (r.nextInt(2) == 0)
            {// para saber si da 0 o 1, si es 0 coge un nombre de la lista de mujeres con el .get
                persona += lm.get(r.nextInt(lm.size())); // lm.get(r.nextInt(lm.size())) coge un elemento de la lista de mujeres persona += porque todavía está vacía
                if (r.nextInt(5) == 3)//da números random de 0 a 4, si sale 3 se pondrá dos nombres
                    persona += " " + lm.get(r.nextInt(lm.size()));
            } else
            {
                persona += lh.get(r.nextInt(lh.size()));
                if (r.nextInt(5) == 2)//da números random de 0 a 4, si sale 3 se pondrá dos nombres
                    persona += " " + lh.get(r.nextInt(lh.size()));
            }
            persona += " " + la.get(r.nextInt(la.size())); //esto proporciona un apellido
            if (r.nextInt(10) != 4)//da números random de 0 a 4, si sale 3 se pondrá dos nombres // != porque tiene que salir más de lo habitual
                persona += " " + la.get(r.nextInt(la.size()));

            ag.println(persona);
        }
    }  
}
