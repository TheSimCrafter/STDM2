import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JFrame frame;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        frame = new JFrame();
        frame.setTitle("Kassensystem");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        JPanel neuerEinkaufPanel = createNeuerEinkaufPanel();
        JPanel einkaufsHistoriePanel = createEinkaufsHistoriePanel();
        JPanel produktPanel = createProduktPanel();

        tabbedPane.addTab("Neuer Einkauf", neuerEinkaufPanel);
        tabbedPane.addTab("Einkaufs-Historie", einkaufsHistoriePanel);
        tabbedPane.addTab("Produkte", produktPanel);

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createNeuerEinkaufPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton btnNeuenEinkaufErfassen = new JButton("Neuen Einkauf erfassen");
        btnNeuenEinkaufErfassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logik für neuen Einkauf
            }
        });
        panel.add(btnNeuenEinkaufErfassen);

        // Weitere UI-Komponenten für die Eingabe von Positionen und Berechnungen hinzufügen

        return panel;
    }

    private JPanel createEinkaufsHistoriePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tabelle für die Einkaufs-Historie
        JTable table = new JTable();
        // Daten für die Tabelle laden
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createProduktPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Produktliste in Tabelle anzeigen
        JTable table = new JTable();
        // Daten für die Tabelle laden
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }
}
