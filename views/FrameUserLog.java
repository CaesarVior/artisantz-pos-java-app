package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FrameUserLog extends JFrame {

    public FrameUserLog() {
        setTitle("Data User dan Log - Artisantz POS");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] userColumns = {"ID User", "Nama", "Username", "Role", "Status"};
        Object[][] userData = {
            {1, "sakti", "sakti ganteng", "Admin", "Aktif"},
            {2, "cesar", "cesar asu", "Kasir", "Aktif"},
            {3, "nasru", "nasru", "Kasir", "Aktif"},
            {4, "atar", "atar", "Kasir", "Nonaktif"},
            {5, "zaman", "zaman", "Kasir", "Nonaktif"}
        };
        JTable userTable = new JTable(new DefaultTableModel(userData, userColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setBorder(BorderFactory.createTitledBorder("Data User"));
        userPanel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        String[] logColumns = {"ID Log", "Waktu", "Username", "Aktivitas", "Keterangan"};
        Object[][] logData = {
            {1, "2026-11-26 09:00", "sakti", "Login", "Berhasil masuk"},
            {2, "2026-11-26 09:15", "sakti", "Tambah Transaksi", "Transaksi #x001"},
            {3, "2026-11-26 09:30", "sakti", "Tambah User", "Menambahkan user nasru"}
        };
        JTable logTable = new JTable(new DefaultTableModel(logData, logColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.setBorder(BorderFactory.createTitledBorder("Log Aktivitas"));
        logPanel.add(new JScrollPane(logTable), BorderLayout.CENTER);

        mainPanel.add(userPanel);
        mainPanel.add(logPanel);

        add(mainPanel, BorderLayout.CENTER);
        add(new JLabel("Data contoh untuk tampilan awal; belum terhubung ke database."),
                BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameUserLog frame = new FrameUserLog();
            frame.setVisible(true);
        });
    }
}
