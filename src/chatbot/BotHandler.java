package chatbot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
//Bothandler class for ChatBot
public class BotHandler extends JFrame implements KeyListener {

    /*instance variables*/
    String marka, model, begenilenUrun;

    /*create arrayList*/
    ArrayList<Bilgisayar> bilgisayarList = new ArrayList<Bilgisayar>();
    ArrayList<Televizyon> televizyonList = new ArrayList<Televizyon>();
    ArrayList<CellPhone> cellPhoneList = new ArrayList<CellPhone>();
    ArrayList<Tweet> cepTweetList = new ArrayList<Tweet>();
    ArrayList<Tweet> bilgTweetList = new ArrayList<Tweet>();
    ArrayList<Tweet> tvTweetList = new ArrayList<Tweet>();
    ArrayList<String> tweetYorum = new ArrayList<String>();

    /*create arrayList to store messages*/
    ArrayList<String> exceptionMessageList = new ArrayList<String>(
            Arrays.asList("maalesef anlasilmadi...", "lutfen tekrarlar misin", "???"));
    ArrayList<String> greetingMessageList = new ArrayList<String>(
            Arrays.asList("ooo selammm..", "merhabalar", "mrb"));
    ArrayList<String> state = new ArrayList<String>(
            Arrays.asList("Teşekkürle iyiyim,Siz?", "Sağolun,siz nasılsınız?"));
    ArrayList<String> farewell = new ArrayList<String>(
            Arrays.asList("Hoşçakalın...", "Güle güle...", "Görüşmek üzere..."));
    //create panel, text areas
    JPanel p = new JPanel();
    JTextArea txtChat = new JTextArea(20, 50);
    JTextArea txtEnter = new JTextArea(1, 50);
    JScrollPane scroll = new JScrollPane(
            txtChat,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    public BotHandler() {

        super("Chat Bot");
        //create some cellphone, computer and television
        cellPhoneList.add(new CellPhone(123, "Asus", "Zenphone3", 16, "3GB"));
        cellPhoneList.add(new CellPhone(124, "Apple", "Iphone7", 64, "2GB"));
        cellPhoneList.add(new CellPhone(125, "Samsung", "GalaxyNote8", 13, "4GB"));
        // bilgisayarList.add(new Bilgisayar(012,"Apple","MacbookAir","Intel i5","16GB","750GB","13.3\""));
        bilgisayarList.add(new Bilgisayar(212, "Lenovo", "LegionY520", "Intel i5", "8GB", "1 TB", "15.6\""));
        bilgisayarList.add(new Bilgisayar(213, "Asus", "N580VD-DM160T", "Intel i7", "16GB", "1 TB", "15.6\""));
        televizyonList.add(new Televizyon(322, "Samsung", "T24D310ES", "72 cm", "LED", "HD"));
        televizyonList.add(new Televizyon(322, "Philips", "32PFS4131/12", "81 cm", "LED", "FULL HD"));
        televizyonList.add(new Televizyon(322, "LG", "55SJ800V.APD", "139 cm", "LED", "4K ULTRA HD"));

        //settings for gui
        setSize(600, 425);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtChat.setEditable(false);
        txtEnter.addKeyListener(this);

        p.add(scroll);
        p.add(txtEnter);
        p.setBackground(new Color(4, 88, 112));
        add(p);

        setVisible(true);

        try {
            UrunOku();
        } catch (IOException ex) {
            Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //call TweetDegerHesapla() method
        TweetDegerHesapla();

        //Use collections.sort then reverse to find most popular product
        Collections.sort(bilgTweetList);
        Collections.reverse(bilgTweetList);

        Collections.sort(tvTweetList);
        Collections.reverse(tvTweetList);

        Collections.sort(cepTweetList);
        Collections.reverse(cepTweetList);

    }
 
 /* Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEnter.setEditable(false);

            String uText = txtEnter.getText();
            txtChat.append("You: " + uText + "\n");
            txtEnter.setText("");
            uText.trim();

            //chatting with user
            if (uText.contains("selam")) {

                decideRandom(greetingMessageList);

            } else if (uText.contains("nasilsiniz?")) {

                decideRandom(state);
            } else if (uText.contains("gule gule")) {

                decideRandom(farewell);
            } else if (uText.contains("urun sececegim")) {
                // select product
                txtChat.append("AI: " + "Lutfen urunu seciniz:" + "\n");
                txtChat.append("AI: " + "1: Cep Telefonu" + "\n");
                txtChat.append("AI: " + "2: Televizyon" + "\n");
                txtChat.append("AI: " + "3: Bilgisayar" + "\n");
            }
            //if the user chose 1 then show cellphone list with popular cellphone
            if (uText.equals("1")) {
                txtChat.append("AI: " + "Cep Telefonu secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Telefonlar:" + "\n");
                for (CellPhone cellP : cellPhoneList) {
                    txtChat.append("AI: " + cellP.getpBrand() + " - " + cellP.getpModel() + "\n");
                }
                txtChat.append("AI:En çok beğenilen ürün: " + cepTweetList.get(0).hashtag + "\n");

            } //if the user chose 2 then show televison list with popular television
            else if (uText.equals("2")) {
                txtChat.append("AI: " + "Televizyon secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Televizyonlar:" + "\n");
                for (Televizyon tv : televizyonList) {
                    txtChat.append("AI: " + tv.getpBrand() + " - " + tv.getpModel() + "\n");

                }
                txtChat.append("AI:En çok beğenilen ürün: " + tvTweetList.get(0).hashtag + "\n");

            } //if the user chose 2 then show televison list with popular computer
            else if (uText.equals("3")) {
                txtChat.append("AI: " + "Bilgisayar secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Bilgisayarlar:" + "\n");
                for (Bilgisayar bilg : bilgisayarList) {
                    txtChat.append("AI: " + bilg.getpBrand() + " - " + bilg.getpModel() + "\n");

                }
                txtChat.append("AI:En çok beğenilen ürün: " + bilgTweetList.get(0).hashtag + "\n");

            } else {
                //call decideRandom() method
                decideRandom(exceptionMessageList);
            }

            //use trim() to remove leading and trailing spaces
            uText.trim();
            //after the first dialog, pass 1 line
            addText("\n");
        }

    }
  /* Handle the key-released event from the text field. 
   *It works when we remove hand from the key
   */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEnter.setEditable(true);
        }
    }
/*Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    }
//generate addText() method
    public void addText(String str) {
        txtChat.setText(txtChat.getText() + str);
    }
    //show messages randomly

    private void decideRandom(ArrayList<String> messageList) {
        int decider = (int) (Math.random() * messageList.size());
        txtChat.append("AI: " + messageList.get(decider) + "\n");
    }
//generate UrunOku() method to read products from file

    public void UrunOku() throws FileNotFoundException, IOException {

        String marka, model, ram, kategori, islemciTip, bRam, harddisk, bEkran, tvEkran, tvEkranTip, tvGorKalite;
        int id, kamera;

        String karakter = ",";
        File file = new File("urunBilgileri.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        while (satir != null) {

            StringTokenizer st = new StringTokenizer(satir, karakter);

            kategori = st.nextToken();
            id = Integer.parseInt(st.nextToken());
            marka = st.nextToken();
            model = st.nextToken();

            if ("Cep Telefonu".equals(kategori)) {
                kamera = Integer.parseInt(st.nextToken());
                ram = st.nextToken();
                CellPhone yeniCellPhone = new CellPhone(id, marka, model, kamera, ram);
                cellPhoneList.add(yeniCellPhone);
                satir = reader.readLine();
            } else if ("Bilgisayar".equals(kategori)) {
                islemciTip = st.nextToken();
                bRam = st.nextToken();
                harddisk = st.nextToken();
                bEkran = st.nextToken();
                Bilgisayar yeniBilg = new Bilgisayar(id, marka, model, islemciTip, bRam, harddisk, bEkran);
                bilgisayarList.add(yeniBilg);
                satir = reader.readLine();

            } else {
                tvEkran = st.nextToken();
                tvEkranTip = st.nextToken();
                tvGorKalite = st.nextToken();
                Televizyon yeniTv = new Televizyon(id, marka, model, tvEkran, tvEkranTip, tvGorKalite);
                televizyonList.add(yeniTv);
                satir = reader.readLine();

            }

        }

    }
//generate TweetDegerHesapla() method to calculate average polarity of tweets

    public void TweetDegerHesapla() {
        String senticWord;
        String durum;
        Double kutupDeg;
        try {
            String karakter = "\t";

            File file = new File("SenticNet.txt");
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String satir = reader.readLine();
            HashMap<String, Double> map = new HashMap<String, Double>();
            while (satir != null) {

                StringTokenizer st = new StringTokenizer(satir, karakter);
                while (st.hasMoreTokens()) {
                    senticWord = st.nextToken().toLowerCase();
                    durum = st.nextToken();
                    kutupDeg = Double.parseDouble(st.nextToken());
                    map.put(senticWord, kutupDeg);
                }
                satir = reader.readLine();
            }

            Scanner scanner2 = null;
            String kategori;
            String hashtag;
            double polarity = 0;
            double topPol = 0;
            double ortPol = 0;

            try {
                scanner2 = new Scanner(new FileReader("tweetBilgileri.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (scanner2.hasNext()) {
                String[] linePiece = scanner2.nextLine().split("_");
                kategori = linePiece[0];
                hashtag = linePiece[1];
                for (int i = 2; i < linePiece.length; i++) {
                    tweetYorum.add(linePiece[i]);
                    String[] tweetWord = linePiece[i].split(" ");
                    for (int j = 0; j < tweetWord.length; j++) {
                        if (map.containsKey(tweetWord[j].toLowerCase())) {
                            polarity = map.get(tweetWord[j].toLowerCase());
                            topPol += polarity;
                        }

                    }

                }

                ortPol = topPol / (linePiece.length - 2); //topPolarity'i, dosyadaki tweet sayısına bölüyor.
                Tweet yeniTweet = new Tweet(hashtag, tweetYorum, ortPol);

                switch (kategori) {
                    case "Cep Telefonu":
                        cepTweetList.add(yeniTweet);
                        break;
                    case "Bilgisayar":
                        bilgTweetList.add(yeniTweet);
                        break;
                    case "Televizyon":
                        tvTweetList.add(yeniTweet);
                        break;
                    default:
                        break;
                }

                tweetYorum.clear();
                polarity = 0;
                topPol = 0;
                ortPol = 0;

            }

        } catch (IOException ex) {
            Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
