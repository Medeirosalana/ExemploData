package exemplo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exemplo6 extends JFrame{

    private JTextArea taTexto;
    private JButton btMostrar;
    private Date agora;
    final long MILI_SEGUNDOS_POR_DIA = 1000*60*60*24;

    public Exemplo6() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Manipulação de Datas e Horas");
        setBounds(100,100,300,200);
        taTexto = new JTextArea();
        btMostrar = new JButton("Mostrar");
        add(taTexto, "Center");
        add(btMostrar,"North");
        agora = new Date();
    }

    private void definirEventos() {
       btMostrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            Calendar calendario1 = Calendar.getInstance();
            Calendar calendario2 = Calendar.getInstance();
            Calendar calendario3 = Calendar.getInstance();
            Calendar calendario4 = Calendar.getInstance();
            try{
                Date data1 = df.parse("01/01/2010");
                calendario1.setTime(data1);
                Date date2 = df.parse("01/03/2010");
                calendario2.setTime(date2);
                long diaData1 = calendario1.getTimeInMillis();
                long diaData2 = calendario2.getTimeInMillis();
                long dif = (diaData2 - diaData1)/ MILI_SEGUNDOS_POR_DIA;
                calendario2.add(Calendar.DAY_OF_YEAR, 30);
                Date trinta = calendario2.getTime();
                Date data3 = df.parse("31/12/2009");
                calendario3.setTime(data3);
                calendario4.setTime(data3);
                calendario3.add(Calendar.DAY_OF_YEAR, 1);
                calendario4.add(Calendar.DAY_OF_YEAR,1);
                Date dia1 = calendario3.getTime();
                Date dia2 = calendario4.getTime();
                taTexto.setText("Data 1 = "+ df.format(data1)+"\n Data 2 = "+ df.format(date2)+"\n Diferença de dias = "+(dif)+
                        "\n30 dias apos a Data 2 = "+df.format(trinta)+"\n Dia primeiro com add = "+ df.format(dia1)+"\n dia primeiro com roll = "+ df.format(dia2));
                
            }catch(ParseException erro){
                JOptionPane.showMessageDialog(null, "Data invalida"+erro.getErrorOffset());
            }
            }
        });
    }
    public static void main(String[] args) {
        JFrame janela = new Exemplo6();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
