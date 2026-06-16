package view;

import static utils.DataValidation.calculateNifLetter;
import static utils.DataValidation.isLetter;
import static utils.DataValidation.isNumber;

import java.awt.dnd.DropTarget;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

/**
 * Interface used to updated a person. It is mandatory to enter the NIF.
 *
 * @author Francesc Perez
 * @version 1.1.0
 */
public class Update extends javax.swing.JDialog {

    public Update(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        DropPhotoListener d = new DropPhotoListener(photo, this);
        DropTarget dropTarget = new DropTarget(photo, d);
        read.setVisible(false);
        update.setEnabled(false);
    }

    public JButton getUpdate() {
        return update;
    }

    public JButton getRead() {
        return read;
    }

    public JTextField getNam() {
        return name;
    }

    public JDatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public JTextField getNif() {
        return nif;
    }

    public JLabel getPhoto() {
        return photo;
    }

    public JButton getReset() {
        return reset;
    }

    public javax.swing.JTextField getEmail() {
        return email;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nif = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateOfBirth = new org.jdatepicker.JDatePicker();
        reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        read = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update - People v1.1.0");
        setMinimumSize(new java.awt.Dimension(810, 280));

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setMaximumSize(new java.awt.Dimension(194, 33));
        update.setMinimumSize(new java.awt.Dimension(194, 33));
        update.setPreferredSize(new java.awt.Dimension(194, 33));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NIF ");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 22));

        nif.setMaximumSize(new java.awt.Dimension(400, 22));
        nif.setMinimumSize(new java.awt.Dimension(400, 22));
        nif.setPreferredSize(new java.awt.Dimension(400, 22));
        nif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nifKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nifKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nifKeyTyped(evt);
            }
        });

        photo.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("<html><center>PHOTO</center></br><br><center> <i>Supported formats: PNG.</i></center></br><br><center><i>Max. size 64KB</i></center></html>");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo.setEnabled(false);
        photo.setMaximumSize(new java.awt.Dimension(150, 135));
        photo.setMinimumSize(new java.awt.Dimension(150, 135));
        photo.setPreferredSize(new java.awt.Dimension(150, 135));
        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 22));

        name.setEnabled(false);
        name.setMaximumSize(new java.awt.Dimension(400, 22));
        name.setMinimumSize(new java.awt.Dimension(400, 22));
        name.setPreferredSize(new java.awt.Dimension(400, 22));
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Date of Birth");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 22));
        jLabel8.setMinimumSize(new java.awt.Dimension(159, 22));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 22));

        dateOfBirth.setEnabled(false);
        dateOfBirth.setMaximumSize(new java.awt.Dimension(359, 22));
        dateOfBirth.setMinimumSize(new java.awt.Dimension(350, 22));
        dateOfBirth.setPreferredSize(new java.awt.Dimension(350, 22));

        reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reset.setText("RESET");
        reset.setMaximumSize(new java.awt.Dimension(194, 33));
        reset.setMinimumSize(new java.awt.Dimension(194, 33));
        reset.setPreferredSize(new java.awt.Dimension(194, 33));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Author: francesc.perez@stucom.com - Version 1.1.0");

        read.setText("readnoVisible");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(334, 334, 334)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addComponent(read))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nif, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(read))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        // La validación y el mensaje de éxito los gestiona el Controller.
        this.dispose();
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        nif.setText("");
        nif.setEditable(true);
        name.setText("");
        name.setEnabled(false);
        email.setText("");
        dateOfBirth.setEnabled(false);
        photo.setIcon(null);
        photo.setEnabled(false);
        update.setEnabled(false);
        read.setVisible(false);
    }

    private void nifKeyTyped(java.awt.event.KeyEvent evt) {
        if (!utils.DataValidation.isNumber(evt.getKeyChar())
                && evt.getKeyChar() != java.awt.event.KeyEvent.VK_BACK_SPACE
                && evt.getKeyChar() != java.awt.event.KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "Type only numbers [0-9]", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }

    private void nifKeyReleased(java.awt.event.KeyEvent evt) {
        if (nif.getText().length() == 8) {
            nif.setText(utils.DataValidation.calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            read.setVisible(true);
        }
    }

    private void nifKeyPressed(java.awt.event.KeyEvent evt) {
        if (nif.getText().length() == 8) {
            evt.consume();
            nif.setText(utils.DataValidation.calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            read.setVisible(true);
        }
    }

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {
    }

    private void photoMouseClicked(java.awt.event.MouseEvent evt) {
        photo.setIcon(null);
    }

    // Variables declaration - do not modify
    private org.jdatepicker.JDatePicker dateOfBirth;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nif;
    private javax.swing.JLabel photo;
    private javax.swing.JButton read;
    private javax.swing.JButton reset;
    private javax.swing.JButton update;
    // End of variables declaration
}
