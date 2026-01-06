package rinda;

public class Apmekletais {
    private String vards;       
    private int rindasId;       
    private String darbiba;     
    
    public Apmekletais(String vards, int rindasId, String darbiba) {
        this.vards = vards;
        this.rindasId = rindasId;
        this.darbiba = darbiba;
    }

    public String getVards() {
        return vards;
    }

    public void setVards(String vards) {
        this.vards = vards;
    }

    public int getRindasId() {
        return rindasId;
    }

    public void setRindasId(int rindasId) {
        this.rindasId = rindasId;
    }

    public String getDarbiba() {
        return darbiba;
    }

    public void setDarbiba(String darbiba) {
        this.darbiba = darbiba;
    }

    @Override
    public String toString() {
        return vards + " (ID: " + rindasId + ", Darbība: " + darbiba + ")";
    }
}
