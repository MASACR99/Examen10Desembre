package com.example.examen10desembre;

public class Entrenament {
    private String nom;
    private String descripcio;

    public static final Entrenament[] entrenaments = {
            new Entrenament("Extremitats a Tope",
                    "5 Flexions a terra\n" +
                            "10 Inclinacions d'una cama\n" +
                            "15 Flexions dorsals\n"),
            new Entrenament("Agonia Màxima",
                    "100 Flexions inclinades\n" +
                            "100 Flexions\n" +
                            "100 Abdominals\n" +
                            "100 Esquats\n"),
            new Entrenament("Entrenament especial",
                    "5 Dorsals\n" +
                            "10 Flexions\n" +
                            "15 Esquats\n"),
            new Entrenament("Força i longitud",
                    "500 Metres màxima velocitat\n" +
                            "21 Llançaments de pes \n" +
                            "21 Flexions\n")
    };


    private Entrenament(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return this.nom;
    }
}

