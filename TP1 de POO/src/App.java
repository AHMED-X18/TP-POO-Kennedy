import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

class PhoneList extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/POO_1";
    private static final String DB_USER = "AHMED JALIL";
    private static final String DB_PASSWORD = "AHMED2006";

    public PhoneList() {
        setTitle("Liste des Téléphones");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(0, 1));
        loadPhones();
        setVisible(true);
    }

    private void loadPhones() {
        String query = "SELECT * FROM telephone";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                addPhonePanel(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPhonePanel(ResultSet rs) throws SQLException {
        String id_tel = rs.getString("id_tel");
        String marque = rs.getString("marque");
        JPanel panel = createPhonePanel(marque, rs);
        add(panel);
    }

    private JPanel createPhonePanel(String marque, ResultSet rs) throws SQLException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Marque : " + marque));
        panel.add(new JLabel("Etat : " + rs.getString("etat")));
        panel.add(new JLabel("Capacité : " + rs.getFloat("capacite") + " Go"));
        panel.add(new JLabel("Prix : " + rs.getFloat("prix") + " FCFA"));
        panel.add(new JLabel("Résolution : " + rs.getFloat("resolution") + " Pixels/pouce"));

        addButtons(panel, marque, rs.getString("id_tel"));
        return panel;
    }

    private void addButtons(JPanel panel, String marque, String id_tel) {
        JButton buyButton = new JButton("Acheter");
        buyButton.addActionListener(e -> JOptionPane.showMessageDialog(this, marque + " acheté avec succès!"));
        panel.add(buyButton);

        JButton checkStolenButton = new JButton("Vérifier s'il a été volé");
        checkStolenButton.addActionListener(e -> checkIfStolen(id_tel));
        panel.add(checkStolenButton);
    }

    private void checkIfStolen(String id_tel) {
        String query = "SELECT p.nom, p.tel, p.quartier FROM voler v " +
                       "JOIN proprietaire p ON v.id_proprio = p.id_proprio " +
                       "WHERE v.id_tel = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id_tel);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String telephone = rs.getString("tel");
                String adresse = rs.getString("quartier");
                JOptionPane.showMessageDialog(this, "Volé !\n Voici les informations sur le propriétaire : \n Nom : " + nom + 
                                              "\nTéléphone : " + telephone + 
                                              "\nAdresse : " + adresse + "\n Vous pouvez le contacter pour lui signaler");
            } else {
                JOptionPane.showMessageDialog(this, "Cet appareil n'a pas été signalé comme volé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la vérification.");
        }
    }
}

class ComputerList extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/POO_1";
    private static final String DB_USER = "AHMED JALIL";
    private static final String DB_PASSWORD = "AHMED2006";

    public ComputerList() {
        setTitle("Liste des Ordinateurs");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(0, 1));
        loadComputers();
        setVisible(true);
    }

    private void loadComputers() {
        String query = "SELECT * FROM ordinateur";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                addComputerPanel(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addComputerPanel(ResultSet rs) throws SQLException {
        String id_ordi = rs.getString("id_ordi");
        String marque = rs.getString("marque");
        JPanel panel = createComputerPanel(marque, rs);
        add(panel);
    }

    private JPanel createComputerPanel(String marque, ResultSet rs) throws SQLException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Marque : " + marque));
        panel.add(new JLabel("Etat : " + rs.getString("etat")));
        panel.add(new JLabel("Capacité : " + rs.getFloat("capacite") + " Go"));
        panel.add(new JLabel("Prix : " + rs.getFloat("prix") + " FCFA"));
        panel.add(new JLabel("Fréquence : " + rs.getFloat("frequence") + " GHz"));

        addButtons(panel, marque, rs.getString("id_ordi"));
        return panel;
    }

    private void addButtons(JPanel panel, String marque, String id_ordi) {
        JButton buyButton = new JButton("Acheter");
        buyButton.addActionListener(e -> JOptionPane.showMessageDialog(this, marque + " acheté avec succès!"));
        panel.add(buyButton);

        JButton checkStolenButton = new JButton("Vérifier s'il a été volé");
        checkStolenButton.addActionListener(e -> checkIfStolen(id_ordi));
        panel.add(checkStolenButton);
    }

    private void checkIfStolen(String id_ordi) {
        String query = "SELECT p.nom, p.tel, p.quartier FROM voler v " +
                       "JOIN proprietaire p ON v.id_proprio = p.id_proprio " +
                       "WHERE v.id_ordi = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id_ordi);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String ordinateur = rs.getString("ordi");
                String adresse = rs.getString("quartier");
                JOptionPane.showMessageDialog(this, "Volé !\n Voici les informations sur le propriétaire : \n Nom : " + nom + 
                "\nOrdinateur : " + ordinateur + 
                "\nAdresse : " + adresse + "\n Vous pouvez le contacter pour lui signaler");
            } else {
                JOptionPane.showMessageDialog(this, "Cet appareil n'a pas été signalé comme volé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la vérification.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Page d'accueil");
            mainFrame.setSize(500, 500);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(new BorderLayout());

            BackgroundPanel backgroundPanel = new BackgroundPanel("/home/ahmed-jalil/Téléchargements/store.png"); // Chemin vers l'image
            backgroundPanel.setLayout(new FlowLayout());

            // Utilisation d'un JLabel pour le texte de bienvenue
            String welcomeText = "<html><div style='text-align: center;'>"
                + "<h2>Bienvenue dans notre boutique !</h2>"
                + "<p>Nous sommes ravis de vous accueillir parmi nous.</p>"
                + "<p>Ici, vous trouverez une sélection exceptionnelle des derniers appareils électroniques,</p>"
                + "<p>allant des smartphones aux ordinateurs, en passant par les accessoires innovants.</p>"
                + "<p>Notre équipe est à votre disposition pour vous aider à trouver le produit qui répondra parfaitement à vos besoins.</p>"
                + "<p>N'hésitez pas à explorer notre magasin et à poser toutes vos questions.</p>"
                + "<p>Merci de choisir notre boutique pour vos besoins technologiques.</p>"
                + "<p>Nous espérons que vous trouverez exactement ce que vous cherchez !</p>"
                + "</div></html>";

            JLabel welcomeLabel = new JLabel(welcomeText);
            welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            welcomeLabel.setForeground(Color.WHITE); // Définir la couleur du texte en blanc
            welcomeLabel.setPreferredSize(new Dimension(1000, 500));

            // Ajouter le JLabel directement sans JScrollPane
            backgroundPanel.add(welcomeLabel);


            JButton phoneButton = new JButton("Acheter un téléphone");
            phoneButton.addActionListener(e -> new PhoneList());
            backgroundPanel.add(phoneButton);

            JButton computerButton = new JButton("Acheter un ordinateur");
            computerButton.addActionListener(e -> new ComputerList());
            backgroundPanel.add(computerButton);

            mainFrame.add(backgroundPanel);
            mainFrame.setVisible(true);
        });
    }
}