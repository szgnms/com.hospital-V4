package hospital.clinics;

public class EmergencyAndAmbulances implements ClinicsInterface<String,String> {
    @Override
    public String clinicName() {
        return "EmergencyAndAmbulances";
    }

    @Override
    public String clinicDoctor() {
        return "Emergency AndAmbulances Specialist";
    }
}
