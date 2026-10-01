import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketBooking extends JFrame implements ActionListener {
    JComboBox<String> movieBox;
    JTextField ticketsField;
    JLabel priceLabel, statusLabel;
    JButton bookBtn, clearBtn;

    int ticketPrice = 150;

    TicketBooking() {
        setTitle("Ticket Booking Counter - VAMSHI ERRA");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));

        JLabel title = new JLabel("MOVIE TICKET BOOKING", SwingConstants.CENTER);
        title.setBounds(50, 10, 350, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        JLabel movieLabel = new JLabel("Select Movie:");
        movieLabel.setBounds(30, 60, 120, 25);
        add(movieLabel);

        String[] movies = {"Baahubali 2", "Salaar", "Kalki 2898AD", "Devara", "Pushpa 2"};
        movieBox = new JComboBox<>(movies);
        movieBox.setBounds(160, 60, 200, 25);
        add(movieBox);

        JLabel ticketLabel = new JLabel("No. of Tickets:");
        ticketLabel.setBounds(30, 100, 120, 25);
        add(ticketLabel);

        ticketsField = new JTextField();
        ticketsField.setBounds(160, 100, 200, 25);
        add(ticketsField);

        priceLabel = new JLabel("Price: Rs. 150 / ticket");
        priceLabel.setBounds(30, 140, 330, 25);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(priceLabel);

        statusLabel = new JLabel("Select movie and enter tickets", SwingConstants.CENTER);
        statusLabel.setBounds(30, 180, 330, 30);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 13));
        add(statusLabel);

        bookBtn = new JButton("Book Ticket");
        bookBtn.setBounds(50, 230, 130, 35);
        bookBtn.setBackground(new Color(0, 150, 0));
        bookBtn.setForeground(Color.WHITE);
        bookBtn.addActionListener(this);
        add(bookBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(220, 230, 130, 35);
        clearBtn.addActionListener(this);
        add(clearBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookBtn) {
            try {
                String movie = (String) movieBox.getSelectedItem();
                int count = Integer.parseInt(ticketsField.getText());
                if (count <= 0) {
                    statusLabel.setText("Enter valid ticket count!");
                    return;
                }
                int total = count * ticketPrice;
                statusLabel.setText("<html>Booked " + count + " tickets for " + movie + "<br>Total: Rs. " + total + "</html>");
                JOptionPane.showMessageDialog(this, "Booking Confirmed!\nMovie: " + movie + "\nTickets: " + count + "\nTotal: Rs. " + total);
            } catch (Exception ex) {
                statusLabel.setText("Please enter number of tickets!");
            }
        }
        if (e.getSource() == clearBtn) {
            ticketsField.setText("");
            statusLabel.setText("Select movie and enter tickets");
        }
    }

    public static void main(String[] args) {
        new TicketBooking();
    }
}