package UI;

import Cluster.APCluster;
import Cluster.IClusterCalculable;
import Cluster.KMeansCluster;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class mainUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel canvasPanel;
    private JButton btn_export;
    private JButton btn_cluster;
    private JTabbedPane tab_Panel;
    private JTextField text_lam;
    private JTextField text_iterNum;
    private JButton btn_clear;
    private JTextField text_PK;
    private JTextField text_iterNum_kmeans;
    private JTextField text_clusterNum;

    private ArrayList<IClusterCalculable> vecList;
    private int currentType = 1;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonOK = new JButton();
        buttonOK.setText("OK");
        panel2.add(buttonOK, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        panel2.add(buttonCancel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        canvasPanel = new JPanel();
        canvasPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        canvasPanel.setBackground(new Color(-1));
        panel1.add(canvasPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(640, 480), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        contentPane.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "操作"));
        tab_Panel = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(tab_Panel, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setPreferredSize(new Dimension(-1, -1));
        tab_Panel.addTab("AP聚类", panel4);
        panel4.setBorder(BorderFactory.createTitledBorder("参数"));
        final JLabel label1 = new JLabel();
        label1.setText("迭代次数");
        panel4.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("阻尼系数");
        panel4.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        text_lam = new JTextField();
        text_lam.setText("0.8");
        panel4.add(text_lam, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        text_iterNum = new JTextField();
        text_iterNum.setText("50");
        panel4.add(text_iterNum, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("相似系数");
        panel4.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        text_PK = new JTextField();
        text_PK.setText("10");
        panel4.add(text_PK, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tab_Panel.addTab("K-Means聚类", panel5);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel6.setBorder(BorderFactory.createTitledBorder("参数"));
        final JLabel label4 = new JLabel();
        label4.setText("迭代次数");
        panel6.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("聚类数目");
        panel6.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        text_clusterNum = new JTextField();
        text_clusterNum.setText("5");
        panel6.add(text_clusterNum, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        text_iterNum_kmeans = new JTextField();
        text_iterNum_kmeans.setText("50");
        panel6.add(text_iterNum_kmeans, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btn_export = new JButton();
        btn_export.setHorizontalAlignment(0);
        btn_export.setText("导出");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(btn_export, gbc);
        btn_cluster = new JButton();
        btn_cluster.setText("聚类");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(btn_cluster, gbc);
        btn_clear = new JButton();
        btn_clear.setText("清空");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(btn_clear, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    class NodeData implements IClusterCalculable {
        float[] vecValues;
        int typeID;
        int ID;

        public NodeData(float[] vecValues, int ID) {
            this.vecValues = vecValues;
            this.ID = ID;
        }


        @Override
        public float[] getVecValues() {
            return vecValues;
        }

        @Override
        public int getID() {
            return ID;
        }

        @Override
        public int getTypeID() {
            return typeID;
        }

        @Override
        public void setTypeID(int typeID) {
            this.typeID = typeID;
        }

        @Override
        public void setVecValues(float[] vecValues) {
            this.vecValues = vecValues;
        }

        @Override
        public void setID(int ID) {
            this.ID = ID;
        }

        @Override
        public Object getObj() {
            return null;
        }
    }

    public mainUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        vecList = new ArrayList<IClusterCalculable>();

//        for (int i = 1; i < 19; i++) {
//            typeBox.addItem(i + "");
////            rgbs[i] = (int) (Math.random() * 1000 % 255);
//        }

//        typeBox.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                currentType = Integer.valueOf((String) e.getItem());
//
//            }
//        });


        canvasPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("type=" + currentType + "\t" + e.getX() + "-" + e.getY());
                Graphics g = canvasPanel.getGraphics();
                switch (currentType % 4) {
                    case 1:
                        g.setColor(new Color(237, 31, 0));
                        break;
                    case 2:
                        g.setColor(new Color(17, 24, 128));
                        break;
                    case 3:
                        g.setColor(new Color(28, 217, 50));
                        break;
                    default:
                        g.setColor(new Color(248, 27, 248));
                        break;
                }
//                g.setColor(new Color(rgbs[currentType]));
//                g.drawArc(e.getX(), e.getY(), 10, 10, 0, 360);
//                g.drawRoundRect(e.getX(), e.getY(), 10, 10, 0, 360);
                g.fillArc(e.getX(), e.getY(), 10, 10, 0, 360);
                //填充坐标点数据
                float[] vecdata = new float[]{
                        e.getX(), e.getY()
                };
                NodeData nd = new NodeData(vecdata, (int) System.currentTimeMillis());
                vecList.add(nd);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        btn_export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONArray vecs = new JSONArray();
                for (IClusterCalculable node : vecList) {
                    JSONObject jnode = new JSONObject();
                    try {
                        jnode.put("ID", node.getID());
                        jnode.put("typeID", node.getTypeID());
                        JSONArray vecCoord = new JSONArray();
                        for (float coor : node.getVecValues()) {
                            vecCoord.put(coor);
                        }
                        jnode.put("vecValues", vecCoord);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    vecs.put(jnode);
                }
                pickPath pp = new pickPath(vecs.toString());
                pp.pack();
                pp.setVisible(true);
//                System.out.println(vecs);
            }
        });

        tab_Panel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(tab_Panel.getSelectedIndex());
//                isAPcluster = ;

            }
        });

        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClear();
            }
        });

        btn_cluster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeData[] vecDatas = new NodeData[vecList.size()];
                for (int i = 0; i < vecList.size(); i++) {
                    IClusterCalculable icc = vecList.get(i);
                    vecDatas[i] = (NodeData) icc;
                }
                IClusterCalculable[][] iClusterCalculables = new IClusterCalculable[0][];
                //检查是什么聚类方法
                switch (tab_Panel.getSelectedIndex()) {
                    case 0://0为AP
                    {
                        int iterNum = Integer.valueOf(text_iterNum.getText());
                        float lam = Float.valueOf(text_lam.getText());
                        float coePK = Float.valueOf(text_PK.getText());
                        APCluster apCluster = new APCluster(vecDatas, iterNum, lam, coePK);
                        iClusterCalculables = apCluster.startCluster();
                    }
                    break;
                    case 1://1为kmeans
                    {
                        int kmeans_iterNum = Integer.valueOf(text_iterNum_kmeans.getText());
                        int clusterNum = Integer.valueOf(text_clusterNum.getText());
                        KMeansCluster kc = new KMeansCluster(clusterNum, kmeans_iterNum);
                        iClusterCalculables = kc.kmeans(vecDatas);
                    }
                    break;
                }

                System.out.println("聚类完毕！");
                canvasPanel.getGraphics().dispose();
                onDrawNodes(iClusterCalculables);
            }
        });


        buttonOK.addActionListener(new

                                           ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   onOK();
                                               }
                                           }

        );

        buttonCancel.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               onCancel();
                                           }
                                       }

        );

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  onCancel();
                              }
                          }
        );

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    //绘图函数，根据已有数据进行绘图
    public void onDrawNodes(IClusterCalculable[][] nodeDatas) {
        Graphics graphics = canvasPanel.getGraphics();
        graphics.setColor(new Color(253, 253, 253));
        graphics.fillRect(0, 0, canvasPanel.getWidth(), canvasPanel.getHeight());
//        g.dispose();
        for (int i = 0; i < nodeDatas.length; i++) {

            int r = (int) (Math.random() * 1000) % 255;
            int g = (int) (Math.random() * 1000) % 255;
            int b = (int) (Math.random() * 1000) % 255;
            int a = (int) (Math.random() * 1000) % 127 + 126;

//            System.out.println(r + "-" + g + "-" + b + "-" + a);
            Color color = new Color(r, g, b, a);
            graphics.setColor(color);
            for (int j = 0; j < nodeDatas[i].length; j++) {
                NodeData node = (NodeData) nodeDatas[i][j];
                graphics.fillArc((int) node.getVecValues()[0], (int) node.getVecValues()[1], 10, 10, 0, 360);
                graphics.drawString("" + node.getTypeID(), (int) node.getVecValues()[0], (int) node.getVecValues()[1]);
            }
        }
        graphics.dispose();
    }

    private void onClear() {
        vecList.clear();
        canvasPanel.repaint();
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        mainUI dialog = new mainUI();
        dialog.setTitle("聚类演示");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}