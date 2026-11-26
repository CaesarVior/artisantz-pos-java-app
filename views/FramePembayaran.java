
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FramePembayaran extends JFrame {

    private JTable tunaiTable;
    private JTable digitalTable;

    public FramePembayaran() {

        setTitle("Artisantz POS - Data Pembayaran");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // =====================================
        // TABEL PEMBAYARAN TUNAI
        // =====================================

        JLabel tunaiLabel = new JLabel(
                "Pembayaran Tunai",
                SwingConstants.CENTER
        );

        tunaiLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tunaiLabel.setAlignmentX(CENTER_ALIGNMENT);

        String[] tunaiColumns = {
            "ID Pembayaran",
            "ID Transaksi",
            "Nominal",
            "Uang Diterima",
            "Status",
            "Waktu Pembayaran",
            "ID Kasir"
        };

        Object[][] tunaiData = {
            {1, 101, 50000, 100000, "berhasil",
                "2026-11-26 09:00:00", 1},

            {2, 102, 35000, 50000, "berhasil",
                "2026-11-26 09:15:00", 2},

            {3, 103, 75000, 100000, "berhasil",
                "2026-11-26 10:00:00", 1},

            {4, 104, 40000, 40000, "berhasil",
                "2026-11-26 10:30:00", 3},

            {5, 105, 60000, 100000, "gagal",
                "2026-11-26 11:00:00", 2}
        };

        DefaultTableModel tunaiModel =
                new DefaultTableModel(tunaiData, tunaiColumns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tunaiTable = new JTable(tunaiModel);

        JScrollPane tunaiScroll = new JScrollPane(tunaiTable);
        tunaiScroll.setPreferredSize(new Dimension(950, 220));

        // =====================================
        // TABEL PEMBAYARAN DIGITAL
        // =====================================

        JLabel digitalLabel = new JLabel(
                "Pembayaran Digital",
                SwingConstants.CENTER
        );

        digitalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        digitalLabel.setAlignmentX(CENTER_ALIGNMENT);

        String[] digitalColumns = {
            "ID Pembayaran",
            "ID Transaksi",
            "Metode Digital",
            "No. Referensi",
            "Nominal",
            "Status",
            "Waktu Pembayaran",
            "ID Kasir"
        };

        Object[][] digitalData = {
            {1, 106, "QRIS", "QR-20261126001", 45000,
                "berhasil", "2026-11-26 09:30:00", 1},

            {2, 107, "Transfer Bank", "TRF-20261126002", 85000,
                "berhasil", "2026-11-26 10:00:00", 2},

            {3, 108, "E-Wallet", "EW-20261126003", 30000,
                "berhasil", "2026-11-26 10:45:00", 3},

            {4, 109, "QRIS", "QR-20261126004", 55000,
                "gagal", "2026-11-26 11:15:00", 1},

            {5, 110, "Transfer Bank", "TRF-20261126005", 120000,
                "berhasil", "2026-11-26 11:30:00", 2}
        };

        DefaultTableModel digitalModel =
                new DefaultTableModel(digitalData, digitalColumns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        digitalTable = new JTable(digitalModel);

        JScrollPane digitalScroll = new JScrollPane(digitalTable);
        digitalScroll.setPreferredSize(new Dimension(950, 220));

        // =====================================
        // MENYUSUN TAMPILAN
        // =====================================

        mainPanel.add(tunaiLabel);
        mainPanel.add(tunaiScroll);

        mainPanel.add(digitalLabel);
        mainPanel.add(digitalScroll);

        add(mainPanel, BorderLayout.CENTER);
    }

    // =====================================
    // MAIN PROGRAM
    // =====================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            FramePembayaran frame = new FramePembayaran();
            frame.setVisible(true);

        });
    }
}
