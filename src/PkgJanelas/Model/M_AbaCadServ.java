package PkgJanelas.Model;

import PkgFerramentas.HandlerIO;
import PkgFerramentas.VarsGlobais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class M_AbaCadServ {
    
    
    public JTextArea txtDesc = new JTextArea();
    
    public JTextField   txtTipo = new JTextField(),
                        txtIp = new JTextField(),
                        txtPorta = new JTextField(),
                        txtValor = new JTextField(),
                        txtEndC = new JTextField(),
                        txtEndS = new JTextField();
    
    public JButton btnCadastrar = new JButton("Cadastrar");
    
    
    JSpinner.DateEditor de;
    public JDatePickerImpl datePicker;
    public JSpinner timePicker;
    public JSpinner valorPicker;
    
    public void setupDaBaguncaToda(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoje");
        p.put("text.month", "Mês");
        p.put("text.year", "Ano");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {
            private String datePattern = "yyyy-MM-dd";
            private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            @Override
            public Object stringToValue(String text) throws ParseException {
                return dateFormatter.parseObject(text);
            }
            @Override
            public String valueToString(Object value) throws ParseException {
                if (value != null) {
                    Calendar cal = (Calendar) value;
                    return dateFormatter.format(cal.getTime());
                }
                return "";
            }
        });
        timePicker = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.SECOND));
        de = new JSpinner.DateEditor(timePicker, "HH:mm:ss");
        de.getTextField().setEditable( false );
        timePicker.setEditor(de);
        valorPicker = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 0.01));
        JSpinner.NumberEditor ne = new JSpinner.NumberEditor(valorPicker, "#.##");
        valorPicker.setEditor(ne);
    }
    
    public void cadastrar(){
        HandlerIO.enviarMsg("{\"id\": \"service\",\"type\": \"create\",\"data\": {\"id_client\": \"" + VarsGlobais.dadosUsuario[0] + "\",\"id_provider\": \"\", \"type\": \"" + txtTipo.getText() + "\",\"description\": \"" + txtDesc.getText().replace("\n", " ") + "\",\"value\": \"" + valorPicker.getValue() + "\",\"id_user_provider\": \"\",\"id_user_client\": \"" + VarsGlobais.dadosUsuario[0] + "\",\"user_client_place\": \"" + txtEndC.getText() + "\",\"service_place\": \"" + txtEndS.getText() + "\",\"date\": \"" + datePicker.getJFormattedTextField().getText() + "\",\"hour\": \"" + de.getTextField().getText() + "\",\"status\": \"aberto\"}}");
    }
}