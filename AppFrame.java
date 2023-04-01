package CompDecomp.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import CompDecomp.comp_decomp.compress;
import CompDecomp.comp_decomp.decompress;

public class AppFrame extends JFrame implements ActionListener {
//     Creating the two buttons using JButton abstract class 
    JButton compressor;
    JButton decompressor;

    AppFrame(){
//         default close operation statement helps to exit from the JFrame portal and backend processing at the same time
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this will help to set the buttons automatically in the middle of the portal
        this.setLayout(new FlowLayout());

//         Creating and assigning the variable name to compressor button
        compressor = new JButton("Select file to compress");
//         Assigning the action listener to the compressor button
        compressor.addActionListener(this);

//         Creating and assigning variable name to decompressor button
        decompressor = new JButton("Select file to decompress");
//         Assigning the action listener to the decompressor button
        decompressor.addActionListener(this);

//         Adding compressor and decompressor buttons on the main portal interface
        this.add(compressor);
        this.add(decompressor);
//         Setting the size and location of the main portal
        this.setSize(300,300);
        this.setLocation(500,200);
//         This will help in setting the background color of our JFrame
        this.getContentPane().setBackground(Color.cyan);
//         Setting the visibility so the we can see the total interface
        this.setVisible(true);

    }

    //action listener - recieves the action events and performs the action accordingly
    //actionPerformed - this function helps to provide the command according to the button pressed
    @Override
    public void actionPerformed(ActionEvent e){
//         If compressor button is used 
        if(e.getSource()==compressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
//                 Storing the absolute path of selected filed
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
//                     Using method function of compress class to compress the selected file
                    compress.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
//         If Decompressor button is used
        if(e.getSource()==decompressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
//                 Storing the absolute path of the selected compressed file
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
//                     Using method function of decompress class to decompress th compressed file
                    decompress.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
