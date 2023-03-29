package CompDecomp.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import CompDecomp.comp_decomp.compress;
import CompDecomp.comp_decomp.decompress;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressor;
    JButton decompressor;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        compressor = new JButton("Select file to compress");
//        compressor.setBounds(50,100,100,30);
        compressor.addActionListener(this);

        decompressor = new JButton("Select file to decompress");
//        decompressor.setBounds(350,100,100,30);
        decompressor.addActionListener(this);

        this.add(compressor);
        this.add(decompressor);
        this.setSize(300,300);
        this.setLocation(500,200);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);

    }

    //action listener - recieves the action events and performs the action accordingly
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    compress.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decompress.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
