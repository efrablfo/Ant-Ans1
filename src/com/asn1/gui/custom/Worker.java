package com.asn1.gui.custom;

import com.asn1.dto.Message;
import com.asn1.services.IWorker;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * Clase que gestiona el comportamiento de la interfaz visual <code>AntFrame</code> 
 * mientras el proceso de compilación está en ejecución
 * @author Efrain.Blanco
 */
public class Worker extends SwingWorker<Integer, String> {

    private JProgressBar progressBar;
    private IWorker iWorker;
    private Message message;
    private static final String SUCCESS_TITLE = "Información";
    private static final String ERROR_TITLE = "**Error**";
    private static final String STATE_PROPERTY = "state";
    private static final String PROGRESS_PROPERTY = "progress";
    private JFrame frame;

    public Worker(){       
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;         
    }

    public IWorker getiWorker() {
        return iWorker;
    }

    public void setiWorker(IWorker iWorker) {
        this.iWorker = iWorker;
    }
    
    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }
    
    private static void failIfInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("Interrupted while searching files");
        }
    }
    
    public void ejecutar(){
        configWorker();
        execute();
    }
    
    @Override
    protected Integer doInBackground(){
        try{
            iWorker.ejecutar();
            if( message != null ){
                message.setType(JOptionPane.INFORMATION_MESSAGE);
                message.setTitle(SUCCESS_TITLE);
            }
        }catch(Exception ex){       
            message = new Message();
            message.setType(JOptionPane.ERROR_MESSAGE);
            message.setTitle(ERROR_TITLE);
            message.setText(ex.getMessage());            
            ex.printStackTrace();
        }
        return 1;
    }

    @Override
    protected void process(final List<String> chunks) {
    }

    public void configWorker() {
        this.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent event) {
                switch (event.getPropertyName()) {
                    case PROGRESS_PROPERTY:
                        progressBar.setValue((Integer) event.getNewValue());
                        break;
                    case STATE_PROPERTY:
                        switch ((StateValue) event.getNewValue()) {
                            case DONE:
                                finishWork();
                                break;
                            case STARTED:
                                initWork();
                                break;
                            case PENDING:
                                showProgressBar(true);
                                break;
                        }
                        break;
                }
            }
        });
    }

    private void initWork() {
        showProgressBar(true);
        if( frame != null ){
            Arrays.stream(frame.getContentPane().
                    getComponents()).forEach(c -> c.setEnabled(false));
        }
    }

    private void finishWork() throws HeadlessException {
        showProgressBar(false);
        if( frame != null ){
            Arrays.stream(frame.getContentPane().
                    getComponents()).forEach(c -> c.setEnabled(true));
        }
        if( message != null ){
            JOptionPane.showMessageDialog(null, message.getText(),
                    message.getTitle(), message.getType());
        }
    }
    
     private void showProgressBar(boolean show) {
        progressBar.setVisible(show);
    }
}
