package views;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FrameMejaPembeli extends JFrame {

    public FrameMejaPembeli() {
        setTitle("Data Meja dan Pembeli - Artisantz POS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel mejaLabel = new JLabel("Data Meja");
        String[] mejaColumns = {"ID Meja", "Kode Meja", "Status", "Updated At"};
        Object[][] mejaData = {
            {1, "M01", "tersedia", "2026-11-26 10:00:00"},
            {2, "M02", "terisi", "2026-11-26 10:15:00"},
            {3, "M03", "reserved", "2026-11-26 10:30:00"},
            {4, "M04", "tersedia", "2026-11-26 10:45:00"}
        };
        JTable mejaTable = new JTable(new DefaultTableModel(mejaData, mejaColumns));
        JScrollPane mejaScroll = new JScrollPane(mejaTable);

        JLabel pembeliLabel = new JLabel("Data Pembeli");
        String[] pembeliColumns = {"ID Pembeli", "Nama Pembeli", "No. HP", "Email"};
        Object[][] pembeliData = {
            {1, "Andi Wijaya", "081234567890", "andi@example.com"},
            {2, "Budi Santoso", "081298765432", "budi@example.com"},
            {3, "Citra Maharani", "085712345678", "citra@example.com"},
            {4, "Dewi Anggraini", "082112223333", "dewi@example.com"}
        };
        JTable pembeliTable = new JTable(new DefaultTableModel(pembeliData, pembeliColumns));
        JScrollPane pembeliScroll = new JScrollPane(pembeliTable);

        mainPanel.add(mejaLabel);
        mainPanel.add(mejaScroll);
        mainPanel.add(pembeliLabel);
        mainPanel.add(pembeliScroll);

        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameMejaPembeli frame = new FrameMejaPembeli();
            frame.setVisible(true);
        });
    }
}
