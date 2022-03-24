//package com.facebook.ui;
//
//import com.facebook.model.Message;
//
//import java.awt.*;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Scanner;
//
//public class MessageUI {
//    static Scanner ais = new Scanner(System.in).useDelimiter("\n");
//
//    public static void messages() throws IOException, InterruptedException, AWTException {
//
//        mainPoint();
//
//    }
//
//    public static void listUsers() throws IOException {
//        Path profileDetailsTable = Paths.get( "src/main/resources/ProfileDetailsTable.txt");
//        List<String> lines = Files.readAllLines(profileDetailsTable);
//        String[] userDetails;
//        for (String line : lines) {
//            userDetails = line.split(";");
//            System.out.println("Id= "+ userDetails[0]+ "; Name = " + userDetails[3]);
//        }
//    }
//
//    public static int getCurrentUserId() {
//        Path currentUserIDTable = Paths.get("src/main/resources/CurrentUserIDTable.txt");
//        try {
//            return Integer.parseInt(Files.readString(currentUserIDTable));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0;//this is not ok
//    }
//
//    public static boolean isValidUserId (int id) throws IOException {
//        Path profileDetailsTable = Paths.get( "src/main/resources/ProfileDetailsTable.txt");
//        List<String> lines = Files.readAllLines(profileDetailsTable);
//        String[] userDetails;
//        boolean found = false;
//        while (found == false) {
//            for (String line : lines) {
//                userDetails = line.split(";");
//
//                if (userDetails[0].equals(Integer.toString(id))) {
//                    found = true;
//                    return true;
//                }
//            }
//            return false;
//        }
//        return false;
//    }
//
//    public static String getNameFromPathString(String path){
//        path=path.replaceFirst(Integer.toString(getCurrentUserId()),"");
//        //System.out.println(path);
//        path=path.replace("_","");
//        path=path.replace("chat","");
//        path=path.replace(".ser","");
//        path=path.replace("surse/","");
//        path=path.replace("resources/","");
//        path=path.replace("src/main/","");
//        int otherUserId=Integer.parseInt(path);
//        path=path+ " " +getNameFromID(otherUserId);
//        path=path.replaceAll("\\d", "");
//        return path;
//    }
//
//
//    public static void mainPoint() throws IOException, InterruptedException, AWTException {
//        System.out.println("Main messenger menu:");
//        System.out.println("option 1 = see users ; option 2 = see chats ; option -1 = back ; exit =0");
//        int selection=getIntFromUnwillingUser();
//        HomeUI homeUI=new HomeUI();
//
//        while (selection<5)
//        {
//            switch(selection){
//                case 0:
//                    System.exit(0);
//                    break;
//                case 1:
//                    listUsers();
//                    toChooseOrNotToChoose();
//                    //see users method
//                    break;
//
//                case 2:
//                    //System.out.println(getCurrentUserId());
//                    listChats(getCurrentUserId());
//                    System.out.println("if you have no chats yet I suggest to go back and see the users and not choose a user blindly");
//                    toChooseOrNotToChoose();
//                    break;
//
//                case -1:
//                    homeUI.showHomeUI();
//                    //MyProfileUI.showMyProfileUI();
//                    // back to main ui
//                    break;
//                default:
//                    System.err.println("Based on my personal intuition your iq is over 112, please try again");
//                    mainPoint();
//            }
//            selection = getIntFromUnwillingUser(); // add this
//        }
//        System.err.println("Based on my personal intuition your iq is over 112, please try again");
//        mainPoint();
//    }
//
//    public static int getIntFromUnwillingUser(){
//        int i=0;
//        boolean done=false;
//        String isi;
//        isi=ais.nextLine();
//        while (!isi.matches("-?\\d+")){
//
//            if(!isi.matches("-?\\d+")){
//                //System.err.println("Based on my personal intuition your iq is over 112, please try again");
//                System.out.println("please give valid number option");
//                isi= ais.nextLine();
//            }
//        }
//        i = Integer.parseInt(isi);
//        return i;
//    }
//
//    public static void toChooseOrNotToChoose() throws IOException, InterruptedException, AWTException {
//        System.out.println("option 1 = choose person you want to interact with ; option -1 = back to MainPoint ; exit =0");
//        int selection = getIntFromUnwillingUser();
//
//        while (selection<2)
//        {
//            switch (selection) {
//                case 0 -> System.exit(0);
//                case 1 -> {
//                    int reciever = chooseUser();
//                    inChatPoint(reciever, selectFile( reciever));
//                }
//                case -1 -> mainPoint();
//                default -> {
//                    System.err.println("Based on my personal intuition your iq is over 112, please try again");
//                    toChooseOrNotToChoose();
//                }
//            }
//            selection = getIntFromUnwillingUser();
//        }
//        System.err.println("Based on my personal intuition your iq is over 112, please try again");
//        toChooseOrNotToChoose();
//    }
//
//    public static void chatsPoint() throws IOException, InterruptedException, AWTException {
//        System.out.println("Chats Point");
//        System.out.println("option 1 = open chat ; option -1 = back mainPoint ; exit =0");
//        listChats(getCurrentUserId());
//        int selection2 = getIntFromUnwillingUser();
//        while (selection2<4)
//        {
//            switch (selection2) {
//                case 0 -> System.exit(0);
//                case 1 -> {
//                    System.out.println("choose the id of the user with chat you want to open");
//                    System.out.println("that's 2 or 3 right now");
//                    int userNr = chooseUser();
//                    String filename_path = selectFile(userNr);
//                    inChatPoint(userNr, filename_path);
//                }
//                case -1 -> mainPoint();
//                default -> {
//                    System.err.println("Based on my personal intuition your iq is over 112, please try again");
//                    chatsPoint();
//                }
//
//            }
//            selection2 = getIntFromUnwillingUser();
//        }
//        System.err.println("Based on my personal intuition your iq is over 112, please try again");
//        chatsPoint();
//    }
//
//    public static void inChatPoint(int receiverNr,String filename_path) throws IOException, InterruptedException, AWTException {
//        listMessages(filename_path);
//        System.out.println("option 1 = write message ; option 2 = reload chat ; option 3 = forward message ;");
//        System.out.println("option 4 = reply to message ; option -1 = back to main point ; exit =0");
//        int selection3 = getIntFromUnwillingUser();
//        while (selection3<5)
//        {
//            switch (selection3) {
//                case 0 -> System.exit(0);
//                case 1 -> {
//                    System.out.println("now introduce the message you want to send");
//                    String mesaj;// = ais.nextLine();// Ii ceva eroare aici ca daca nu scriu chestia asta redundanta, nu merge; :)))))
//                    mesaj = ais.nextLine();
//                    //System.out.println("punct 1");
//                    Message mesaj1 = new Message(getCurrentUserId(), receiverNr, mesaj);// I should move this to the write message function
//                    writeMessage(mesaj1, filename_path);
//                    inChatPoint(receiverNr, filename_path);
//                }
//                case 2 -> {
//                    //listMessages(filename_path);
//                    inChatPoint(receiverNr, filename_path);
//                }
//                case 3 -> {
//                    System.out.println("choose the message you want to forward");
//                    int message_id = ais.nextInt();
//                    String messageToForward = getMessage(filename_path, message_id);
//                    System.out.println("choose the user you want to send the message to");
//                    int receiverOfForward = chooseUser();
//                    forwardMessage(messageToForward, receiverOfForward);
//                    System.out.println("you have been switched to the chat you forwarded the message to");
//                    inChatPoint(receiverOfForward, selectFile( receiverOfForward));//use the get user here also
//                }
//                case 4 -> {
//                    System.out.println("choose message you want to reply to");
//                    int message_id=ais.nextInt();
//                    System.out.println("now type in the text of the reply");
//                    String replyMesaj= ais.nextLine();
//                    replyMesaj=ais.nextLine();
//                    replyToMessage(replyMesaj,message_id,filename_path,receiverNr);
//                    inChatPoint(receiverNr, filename_path);
//                }
//
//                case -1 -> mainPoint();
//                default -> {
//                    System.err.println("Based on my personal intuition your iq is over 112, please try again");
//                    inChatPoint(receiverNr,filename_path);
//                }
//            }
//            selection3 = getIntFromUnwillingUser();
//        }
//        System.err.println("Based on my personal intuition your iq is over 112, please try again");
//        inChatPoint(receiverNr,filename_path);
//
//    }
//
//    public static void forwardMessage(String Mesaj,int toWho) throws IOException {
//        String File=selectFile(toWho);
//        Message messageToForward=new Message(getCurrentUserId(),toWho,"--Forwarded--"+Mesaj);
//        writeMessage(messageToForward,File);
//    }
//
//    public static void replyToMessage(String Mesaj,int whichMessage, String filename_path, int recieverNr) throws IOException {
//        Message mesajBaza = getMessageObject(filename_path,whichMessage);
//        if(mesajBaza.getMessage().contains("_reply*")){
//            mesajBaza.setMessage(mesajBaza.getMessage().replace("_reply*",""));
//        }
//        writeMessage(mesajBaza,filename_path);
//        Message mesajReply = new Message(getCurrentUserId(),recieverNr,"_reply*"+Mesaj);
//        writeMessage(mesajReply,filename_path);
//
//    }
//
//    public static int chooseUser() throws IOException {
//        //listUsers();
//        System.out.println("please indicate the id of the user you want to send message to");
//        int userNr = ais.nextInt();
//        while (!isValidUserId(userNr)){
//            System.out.println("no such user, try again:");
//            userNr = getIntFromUnwillingUser();
//        }
//        return userNr;
//    }
//
//
//    public static String getMessage(String path1, int message_id){
//        try {
//            FileInputStream fileIn = new FileInputStream(path1);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            Object obj = null;
//            try {
//                while ((obj = in.readObject()) != null) {
//                    if (obj instanceof Message) {
//                        if(((Message) obj).getMessage_id()==message_id){
//                            return ((Message) obj).getMessage();
//                        }
//                        //System.out.println(((Message) obj).toString());
//                    }
//                }
//            } catch (EOFException e) {
//                System.out.println("no messages to be forwarded in file\n");
//            }
//            in.close();
//            fileIn.close();
//        }catch(EOFException ef){
//            System.out.println("nothing in file\n");
//            return "";
//        }catch (IOException i) {
//            i.printStackTrace();
//            return "";
//        } catch (ClassNotFoundException c) {
//            System.out.println("Message class not found");
//            c.printStackTrace();
//            return "";
//        }
//        return "";
//    }
//
//    public static Message getMessageObject(String path1, int message_id){
//        try {
//            FileInputStream fileIn = new FileInputStream(path1);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            Object obj = null;
//            try {
//                while ((obj = in.readObject()) != null) {
//                    if (obj instanceof Message) {
//                        if(((Message) obj).getMessage_id()==message_id){
//                            return (Message) obj;
//                        }
//                        //System.out.println(((Message) obj).toString());
//                    }
//                }
//            } catch (EOFException e) {
//                System.out.println("no messages to be forwarded in file\n");
//            }
//            in.close();
//            fileIn.close();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("message not found");
//        return null;
//    }
//
//
//    public static void createFile(String path1){
//        try {
//            File fileIn = new File(path1);
//            fileIn.createNewFile();
//
//        }catch (IOException fnfe){
//            System.out.println("Exception in selectOrCreateFile");
//        }
//    }
//
//    public static String selectFile( int receiver_id) throws IOException {
//
//        String filename_path1=String.format("src/main/resources/surse/_%s_%s_chat.ser",getCurrentUserId(),receiver_id);
//        String filename_path2=String.format("src/main/resources/surse/_%s_%s_chat.ser",receiver_id,getCurrentUserId());
//
//        Path path1 = Paths.get(filename_path1);
//        Path path2 = Paths.get(filename_path2);
//        if(Files.exists(path1)){
//            return filename_path1;
//        }else if(Files.exists(path2)){
//            return filename_path2;
//        }
//        createFile(filename_path1);
//        return filename_path1;
//
//    }
//
//    public static String getNameFromID(int id) {
//        Path profileDetailsTable = Paths.get("src/main/resources/ProfileDetailsTable.txt");
//        List<String> lines = null;
//        try {
//            lines = Files.readAllLines(profileDetailsTable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] userDetails;
//        boolean found = false;
//        while (found == false) {
//            for (String line : lines) {
//                userDetails = line.split(";");
//
//                if (userDetails[0].equals(Integer.toString(id))) {
//                    found = true;
//                    return userDetails[3];
//
//                }
//            }
//        }
//        return "0";// this ain't right either
//    }
//
//    public static void listChats(int user_id){
//        System.out.println("Current chats:");
//        File f = new File("src/main/resources/surse");
//
//        FilenameFilter filter = new FilenameFilter() {
//            @Override
//            public boolean accept(File f, String name) {
//                return name.contains("_"+getCurrentUserId());// get userid instead of just 1 and the asking sequence will be _1_
//            }
//        };
//
//        String[] pathnames = f.list(filter);
//
//        assert pathnames != null;
//        for (String pathname : pathnames) {
//            // Print the names of files and directories
//            pathname=pathname.replaceFirst(Integer.toString(getCurrentUserId()),"");
//            //System.out.println(pathname);
//            pathname=pathname.replace("_","");
//            pathname=pathname.replace("chat","");
//            pathname=pathname.replace(".ser","");
//            pathname=pathname.replace("resources/","");
//            pathname=pathname.replace("src/main/","");
//            int otherUserId=Integer.parseInt(pathname);
//            pathname=pathname+ " " +getNameFromID(otherUserId);
//            System.out.println(pathname);
//        }
//    }
//
//    public static void listMessages(String path1){
//        System.out.println("here are the messages with: "+getNameFromPathString(path1)+ " so far:");
//        System.out.println("--------------------------------------------------------------------------------");
//        try {
//            FileInputStream fileIn = new FileInputStream(path1);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            Object obj = null;
//            try {
//                while ((obj = in.readObject()) != null) {
//                    if (obj instanceof Message) {
//                        System.out.println(((Message) obj).toString());
//                    }
//                }
//            } catch (EOFException e) {
//                System.out.println("--------------------------------------------------------------------------------");
//                System.out.println("reached end of file\n");
//            }
//            in.close();
//            fileIn.close();
//        }catch(EOFException ef){
//            System.out.println("nothing in file\n");
//        }catch (IOException i) {
//            i.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Message class not found");
//            c.printStackTrace();
//        }
//    }
//
//    public static void writeMessage(Message mesaj1, String path1){
//        try {
//            FileOutputStream fileOut = new FileOutputStream(path1,true);
//
//            File fi = new File(path1);
//
//            if (fi.length() == 0) {
//                ObjectOutputStream out = new ObjectOutputStream(fileOut);
//                out.writeObject(mesaj1);
//                out.close();
//            }
//
//            // There is content in file to be write on
//            else {
//
//                MyObjectOutputStream oos = null;
//                oos = new MyObjectOutputStream(fileOut);
//                oos.writeObject(mesaj1);
//
//                // Closing the FileOutputStream object
//                // to release memory resources
//                oos.close();
//            }
//
//
//            fileOut.close();
//            //System.out.printf("Serialized data is saved in %s\n",path1);
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
//    }
//
//}
//
//class MyObjectOutputStream extends ObjectOutputStream {
//
//    // Constructor of this class
//    // 1. Default
//    MyObjectOutputStream() throws IOException
//    {
//
//        // Super keyword refers to parent class instance
//        super();
//    }
//
//    // Constructor of this class
//    // 1. Parameterized constructor
//    MyObjectOutputStream(OutputStream o) throws IOException
//    {
//        super(o);
//    }
//
//    // Method of this class
//    public void writeStreamHeader() throws IOException
//    {
//    }
//}
