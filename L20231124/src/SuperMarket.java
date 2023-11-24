import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SuperMarket extends JFrame {

    private ArrayList<String> productList; // 商品列表

    public SuperMarket() {
        // 初始化商品列表
        productList = new ArrayList<>();

        // 设置窗口标题
        setTitle("超市管理系统");

        // 设置全屏显示
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 创建商品列表区域
        JTextArea productListArea = new JTextArea(40, 60);
        productListArea.setEditable(false);
        updateProductList(productListArea);

        JScrollPane scrollPane = new JScrollPane(productListArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 创建按钮和操作面板
        JPanel operationPanel = new JPanel(new GridLayout(3, 1));
        JButton stockInButton = new JButton("入库");
        JButton stockOutButton = new JButton("出库");
        JButton queryButton = new JButton("查询");

        // 添加按钮到操作面板
        operationPanel.add(stockInButton);
        operationPanel.add(stockOutButton);
        operationPanel.add(queryButton);

        // 添加操作面板到主面板
        mainPanel.add(operationPanel, BorderLayout.EAST);

        // 添加主面板到窗口
        add(mainPanel);

        // 设置按钮的点击事件监听器
        stockInButton.addActionListener(new ActionListener() {
            // 这里采用接口来实现匿名内部类  ActionListener是一个接口，必须通过实现他的类来实例化对象
            @Override
            public void actionPerformed(ActionEvent e) {
                String newProduct = JOptionPane.showInputDialog(SuperMarket.this, "请输入要入库的商品名称:");
                if (newProduct != null && !newProduct.isEmpty()) {
                    productList.add(newProduct);
                    updateProductList(productListArea);
                }
            }
        });

        stockOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = JOptionPane.showInputDialog(SuperMarket.this, "请输入要出库的商品名称:");
                if (selectedProduct != null && !selectedProduct.isEmpty()) {
                    if (productList.contains(selectedProduct)) {
                        productList.remove(selectedProduct);
                        updateProductList(productListArea);
                    } else {
                        JOptionPane.showMessageDialog(SuperMarket.this, "该商品不存在于库存中");
                    }
                }
            }
        });

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder productListString = new StringBuilder("商品列表：\n");
                for (String product : productList) {
                    productListString.append(product).append("\n");
                }
                JOptionPane.showMessageDialog(SuperMarket.this, productListString.toString());
            }
        });

        // 设置窗口可见
        setVisible(true);
    }

    // 更新商品列表显示
    private void updateProductList(JTextArea productListArea) {
        productListArea.setText("商品列表：\n");
        Font font = new Font("微软雅黑", Font.PLAIN, 100); // 设置字体 Arial，普通样式，大小为 16
        productListArea.setFont(font); // 设置字体
        for (String product : productList) {
            productListArea.append(product + "\n");
        }
    }


    public static void main(String[] args) {
        // 创建超市管理系统实例
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SuperMarket();
            }
        });
    }
}



