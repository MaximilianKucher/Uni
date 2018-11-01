package Rechnungen.jaxb;

import java.io.File;
import javax.xml.bind.*;

import Rechnungen.jaxb.RECHNUNGEN.RECHNUNG;

public class Mahntext {
  public static void main(String[] args) throws Exception{
    try {
      JAXBContext context = JAXBContext.newInstance("Rechnungen.jaxb");
      Unmarshaller unM = context.createUnmarshaller();
      RECHNUNGEN rechnungen = (RECHNUNGEN) JAXBIntrospector.getValue(unM.unmarshal(new File("src\\Rechneruebung4.xml")));
      
      for(RECHNUNG rechnung : rechnungen.getRECHNUNG()) {
        System.out.println(rechnung.getNAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER().getANREDE() + " " 
          + rechnung.getNAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER().getNAME());
        System.out.println("Bitte zahlen Sie endlich den geforderten Betrag");
        System.out.println("von " + rechnung.getENTGELDINEURO() + " " + rechnung.getLEISTUNGEN().getLEISTUNG().get(0).getWAEHRUNG() + " auf das Konto");
        boolean pattern = rechnung.getZAHLUNGSMOEGLICHKEITEN().getDEUTSCHLANDINTERN() != null & rechnung.getZAHLUNGSMOEGLICHKEITEN().getDEUTSCHLANDINTERN().getKONTONUMMER() != null;
        if(pattern) {
          String bank = rechnung.getZAHLUNGSMOEGLICHKEITEN().getDEUTSCHLANDINTERN().getBANK();
          if(bank != null) {
            System.out.print(bank);
          }
          String BIC = rechnung.getZAHLUNGSMOEGLICHKEITEN().getDEUTSCHLANDINTERN().getBIC();
          if(BIC != null) {
            System.out.print(" " + BIC);
          }
          System.out.print(" " + rechnung.getZAHLUNGSMOEGLICHKEITEN().getDEUTSCHLANDINTERN().getKONTONUMMER() + " ein.\n");
        } else if (!pattern & rechnung.getZAHLUNGSMOEGLICHKEITEN().getAUSSERHALBDEUTSCHLANDS() != null) {
            System.out.print(rechnung.getZAHLUNGSMOEGLICHKEITEN().getAUSSERHALBDEUTSCHLANDS().getBIC() + " "
              + rechnung.getZAHLUNGSMOEGLICHKEITEN().getAUSSERHALBDEUTSCHLANDS().getKONTONUMMER() + " ein.\n");
        }
        String tel = rechnung.getNAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER().getTELEFONNUMMER();
        if(tel != null) {
          System.out.println("Falls Sie trotzdem noch unverschämt genug sind");
          System.out.println("und Fragen haben, dann können Sie mich jederzeit");
          System.out.println("unter " + tel + " erreichen.");
        }
        System.out.println("Hochachtungsvoll");
        System.out.println(rechnung.getNAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER().getNAME() + "\n\n");
      }
    } catch(Exception e) {
      System.out.println("Exception: " + e.getLocalizedMessage());
      e.printStackTrace();
    }
  }
}
