import java.util.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        LinkedList<Partition> partitions = new LinkedList<Partition>();
        LinkedList<Process> processes = new LinkedList<Process>();


        System.out.print("Enter Number of partitions : ");
        int PartitionsNum = input.nextInt();
        String PtName ;
        int PtSize;
        for (int i = 0; i < PartitionsNum ; i++) {

            System.out.println("Enter Partition "+(i+1)+" Name and its size ");
            PtName = input.next();
            PtSize = input.nextInt();
            Partition partition = new Partition(PtName, PtSize,false);
            partitions.add(partition);
        }
        System.out.print("Enter Number of processes : ");
        int NumOfProcesses = input.nextInt();
        String PrName ;
        int PrSize;
        for (int i = 0; i < NumOfProcesses ; i++) {
            System.out.println("Enter Process "+(i+1)+" name and its size ");
            PrName = input.next();
            PrSize = input.nextInt();
            Process process = new Process(PrName, PrSize,false);
            processes.add(process);
        }
        //for trying
        /*String[] PName = {"partition0","partition1","partition2","partition3","partition4","partition5"};
        int [] PSize={90,20,5,30,120,80};
        for (int i = 0; i < PName.length ; i++) {
            Partition partition = new Partition(PName[i], PSize[i],false);
            partitions.add(partition);
        }

        String[] Pname = {"process1","process2","process3","process4"};
        int [] Psize={15,90,30,100};
        for (int i = 0; i < Pname.length ; i++) {

            Process process = new Process(Pname[i], Psize[i],false);
            processes.add(process);
        }*/

        System.out.println("Select your choice: ");
        System.out.println("1. First fit \n2. Worst fit \n3. Best fit\n");
        int policy = input.nextInt();
        if (policy==1){
            FirstFit F = new FirstFit(processes, partitions);
            F.FirstFit();
        }
        else if (policy==2)
        {
            WorstFit W = new WorstFit(processes, partitions);
            W.WorstFit();
        }
        else{
            BestFit B = new BestFit(processes, partitions);
            B.BestFit();
        }
    }
}