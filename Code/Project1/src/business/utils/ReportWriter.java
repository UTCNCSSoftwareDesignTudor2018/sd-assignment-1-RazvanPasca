package business.utils;

import model.RegisterEntry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriter {

    private String fileName;
    BufferedWriter bw;
    FileWriter fw;

    public ReportWriter(String name) {
        this.fileName = name;
    }

    public ReportWriter() {
    }

    public void writeReport(List<RegisterEntry> registerEntries) throws IOException {
        this.fw = new FileWriter(this.fileName, true);
        this.bw = new BufferedWriter(fw);
        if (registerEntries.size() == 0)
            bw.write("there are no entries for this student");
        else
            for (RegisterEntry registerEntry : registerEntries) {
                bw.write(registerEntry.toString());
            }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void closeConnections() throws IOException {
        this.bw.close();
        ;
        this.fw.close();
    }
}
