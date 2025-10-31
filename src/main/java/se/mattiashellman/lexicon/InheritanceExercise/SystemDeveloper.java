package se.mattiashellman.lexicon.InheritanceExercise;

import java.util.Arrays;

public class SystemDeveloper extends Employee {
    private final double CERTIFICATE_EXTRA = 1000, LANGUAGE_EXTRA = 1500;
    private String[] certificates = new String[0];
    private String[] languages = new String[0];

    public SystemDeveloper(String name, String[] certificates, String[] languages) {
        super(name);
        addCertificates(certificates);
        addLanguages(languages);
    }

    public String[] getCertificates() {
        return certificates;
    }

    public void addCertificates(String[] certificatesToAdd) {
        String[] newCertificates = Arrays.copyOf(this.certificates, this.certificates.length + certificatesToAdd.length);
        System.arraycopy(certificatesToAdd, 0, newCertificates, this.certificates.length, certificatesToAdd.length);
        this.certificates = newCertificates;
        calculateSalary();
    }

    public String[] getLanguages() {
        return languages;
    }

    public void addLanguages(String[] languagesToAdd) {
        String[] newLanguages = Arrays.copyOf(this.languages, this.languages.length + languagesToAdd.length);
        for (int i = 0 ; i < languagesToAdd.length; i++) {
            newLanguages[this.languages.length + i] = languagesToAdd[i];
        }
        this.languages = newLanguages;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        setSalary(BASE_SALARY + (CERTIFICATE_EXTRA * certificates.length) + (LANGUAGE_EXTRA * languages.length));
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, hired: %s, salary: %.1f, certificates: %s, languages: %s",
                getId(), getName(), getHired(), getSalary(), Arrays.toString(getCertificates()), Arrays.toString(getLanguages()));
    }
}
