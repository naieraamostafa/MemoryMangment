public class Process {

    String ProcessName;
    int ProcessSize;
    boolean Allocated;
    public Process() {
    }

    public Process(String PName, int PSize,boolean allocated) {
        ProcessName = PName;
        ProcessSize = PSize;
        Allocated = allocated;
    }
    public void setProcessName(String PName) {
        ProcessName = PName;
    }
    public String getProcessName() {
        return ProcessName;
    }
    public void setProcessSize(int PSize) {
        ProcessSize = PSize;
    }
    public int getProcessSize() {
        return ProcessSize;
    }

}