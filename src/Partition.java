public class Partition {

    String PartitionName;
    int PartitionSize;
    boolean Status;
    Process process;
    public Partition() {
    }

    public Partition(String PtName, int PtSize,boolean s) {
        PartitionName = PtName;
        PartitionSize = PtSize;
        Status = s;
    }
    public void setPartitionName(String ptName) {
        PartitionName = ptName;
    }
    public String getPartitionName() {
        return PartitionName;
    }
    public void setPartitionSize(int ptSize) {
        PartitionSize = ptSize;
    }
    public int getPartitionSize() {
        return PartitionSize;
    }

    public Process getProcess() {
        return process;
    }
    public void setProcess(Process process) {
        this.process = process;
    }

}