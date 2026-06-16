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
 * Interface used to register a person. It is mandatory to enter at least the
 * NIF and the name.
 *
 * @author Francesc Perez
 * @version 1.1.0
 */
public class Insert extends javax.swing.JDialog {

    private org.jdatepicker.JDatePicker dateOfBirth;

    public Insert(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DropPhotoListener d = new DropPhotoListener(photo, this);
        DropTarget dropTarget = new DropTarget(photo, d);
        insert.setEnabled(false);

        // Issue: drag text on photo label
        photo.setText("<html><center>PHOTO</center><br><center><b>Drag your file here</b></center><br><center><i>Supported format: PNG.</i></center><br><center><i>Max. size 64KB</i></center></html>");

        // Issue: placeholder text for form fields
        nif.putClientProperty("JTextField.placeholderText", "Enter NIF number, letter is calculated (e.g., 12345678)");
        name.putClientProperty("JTextField.placeholderText", "Enter full name");
        email.putClientProperty("JTextField.placeholderText", "Enter email");

        // Issue: DatePicker button text
        dateOfBirth = new org.jdatepicker.JDatePicker();
        JButton datePickerButton = (JButton) dateOfBirth.getComponent(1);
        datePickerButton.setText("Select a date");
        datePickerButton.setPreferredSize(null); 
    }

    public JButton getReset() {
        return reset;
    }

    public JButton getInsert() {
        return insert;
    }

    public JTextField getNam() {
        return name;
    }

    public JDatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public javax.swing.JTextField getEmail() {
        return email;
    }

    public JTextField getNif() {
        return nif;
    }

    public JLabel getPhoto() {
        return photo;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        insert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nif = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert - People v1.1.0");
        setMinimumSize(new java.awt.Dimension(810, 280));

        insert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        insert.setText("INSERT");
        insert.setMaximumSize(new java.awt.Dimension(187, 33));
        insert.setMinimumSize(new java.awt.Dimension(187, 33));
        insert.setPreferredSize(new java.awt.Dimension(187, 33));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Name");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 22));

        name.setMaximumSize(new java.awt.Dimension(400, 22));
        name.setMinimumSize(new java.awt.Dimension(400, 22));
        name.setPreferredSize(new java.awt.Dimension(400, 22));
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reset.setText("RESET");
        reset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reset.setMaximumSize(new java.awt.Dimension(187, 33));
        reset.setMinimumSize(new java.awt.Dimension(187, 33));
        reset.setPreferredSize(new java.awt.Dimension(187, 33));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        photo.setBackground(new java.awt.Color(255, 255, 255));
        photo.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("<html><center>PHOTO</center></br><br><center> <i>Supported format: PNG.</i></center></br><br><center><i>Max. size 64KB</i></center></html>");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo.setMaximumSize(new java.awt.Dimension(150, 135));
        photo.setMinimumSize(new java.awt.Dimension(150, 135));
        photo.setPreferredSize(new java.awt.Dimension(150, 135));
        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("NIF");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 22));

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Date of Birth");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 22));
        jLabel8.setMinimumSize(new java.awt.Dimension(150, 22));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Author: francesc.perez@stucom.com - Version 1.1.0");
        jLabel2.setRequestFocusEnabled(false);

        jLabel6.setText("EMAIL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(email)))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void showInsert() {
        if (!name.getText().isEmpty() && !nif.isEditable()) {
            insert.setEnabled(true);
        } else {
            insert.setEnabled(false);
        }
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        nif.setEditable(true);
        nif.setText("");
        name.setText("");
        photo.setIcon(null);
        email.setText("");
        LocalDate dateLocate = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = dateLocate.atStartOfDay(systemTimeZone);
        Date dateUtil = java.sql.Date.from(zonedDateTime.toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateUtil);
        DateModel<Calendar> dateModel = (DateModel<Calendar>) dateOfBirth.getModel();
        dateModel.setValue(calendar);
        dateOfBirth.getModel().setValue(null);
        insert.setEnabled(false);
    }

    private void nifKeyTyped(java.awt.event.KeyEvent evt) {
        if (!isNumber(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "Type only numbers [0-9]", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {
        if (!isLetter(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "Type only uppercase or lowercase letters, hyphens, and whitespace.", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            evt.consume();
        } else if (isLetter(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
            showInsert();
        }
    }

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {
        showInsert();
    }

    private void photoMouseClicked(java.awt.event.MouseEvent evt) {
        photo.setIcon(null);
    }

    private void nifKeyReleased(java.awt.event.KeyEvent evt) {
        if (nif.getText().length() == 8) {
            nif.setText(calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            showInsert();
        }
    }

    private void nifKeyPressed(java.awt.event.KeyEvent evt) {
        if (nif.getText().length() == 8) {
            evt.consume();
            nif.setText(calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            showInsert();
        }
    }

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {
        // La validación del email y el mensaje de éxito los gestiona el Controller.
        // Este método solo cierra el diálogo para que el Controller pueda continuar.
        this.dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField email;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nif;
    private javax.swing.JLabel photo;
    private javax.swing.JButton reset;
    // End of variables declaration
}