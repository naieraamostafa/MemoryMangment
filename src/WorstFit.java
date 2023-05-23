import java.util.*;
public class WorstFit {
    Scanner input = new Scanner(System.in);

    LinkedList<Process> processes;
    LinkedList<Partition> partitions;
    static int sz;
    public WorstFit(LinkedList<Process> processes, LinkedList<Partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
        sz = partitions.size();
    }
    public void WorstFit() {

        for (int i = 0; i < processes.size(); i++) {
            int WIdx = -1;
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize) {
                    if (WIdx == -1)
                        WIdx = j;
                    else if (partitions.get(WIdx).PartitionSize < partitions.get(j).PartitionSize)
                        WIdx = j;
                }
            }
            if (WIdx != -1) {
                processes.get(i).Allocated = true;
                partitions.get(WIdx).setProcess(processes.get(i));
                partitions.get(WIdx).PartitionSize -= processes.get(i).ProcessSize;
                partitions.get(WIdx).Status = true;

                if (partitions.get(WIdx).PartitionSize > 0) {
                    sz += 1;
                    Partition partition = new Partition("partition" + (sz - 1), partitions.get(WIdx).PartitionSize,
                            false);
                    partitions.add(WIdx + 1, partition);
                    partitions.get(WIdx).PartitionSize = 0;
                }
            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            if (partitions.get(i).Status == true) {
                System.out
                        .println(partitions.get(i).PartitionName + "(" + partitions.get(i).process.ProcessSize + " KB)"
                                + "=> " + partitions.get(i).process.ProcessName);
            } else {
                System.out.println(partitions.get(i).PartitionName + "(" + partitions.get(i).PartitionSize + " KB)"
                        + "=> External Fragmentation");
            }
        }
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).Allocated) {
                System.out.println(processes.get(i).ProcessName + " Can Not be Allocated");
            }
        }

        System.out.println("Do you want to compact?\n1. yes\n2. no");
        int cmpt = Integer.parseInt(input.nextLine());
        if (cmpt == 1) {
            int totalRemaining = 0;
            LinkedList<Partition> afterCompaction = new LinkedList<>();
            LinkedList<Process> remainingProcesses = new LinkedList<>();
            for (Partition p : partitions) {
                if (p.Status == false)
                    totalRemaining += p.PartitionSize;
                else
                    afterCompaction.add(p);
            }
            sz += 1;
            afterCompaction.add(new Partition("partition" + (sz - 1),totalRemaining ,false));

            for(Process p : processes){
                if(p.Allocated == false){
                    remainingProcesses.add(p);
                }
            }
            WorstFit w=new WorstFit(remainingProcesses, afterCompaction);
            w.WorstFit();
        }
    }
}
