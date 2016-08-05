package exemplo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.input.DataFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Exemplo5 extends JFrame{
    private JTextArea taTexto;
    private JButton btMostrar;
    private Date agora;
    final long MILI_SEGUNDOS_POR_DIA = 1000*60*60*24;

    public Exemplo5() {
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
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(agora);
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minuto = calendario.get(Calendar.MINUTE);
                int segundo = calendario.get(Calendar.SECOND);
                String mensagem = "";
                if(hora< 6){mensagem = "Boa Madrugada!";
                }else if(hora < 12){
                mensagem = "Bom dia!";
                }else if(hora < 18){
                mensagem = "Boa Tarde!";
                }else{
                mensagem = "Boa noite!";
                }
                taTexto.setText("Data Atual "+ df.format(agora)+ "\nHora atual "+ hora + "h: "+ minuto +"m: "+ segundo + "s"+ "\n"+mensagem);
            }
        });
    }
    public static void main(String[] args) {
        JFrame janela = new Exemplo5();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    
}
