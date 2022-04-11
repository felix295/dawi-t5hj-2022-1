package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Producto;
import model.Provedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCodigo;
	JComboBox cboCategorias;
	JComboBox cboProvedor;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblProvedor = new JLabel("Provedor :");
		lblProvedor.setBounds(250, 103, 102, 14);
		contentPane.add(lblProvedor);
		
		cboProvedor = new JComboBox();
		cboProvedor.setBounds(320, 103, 86, 22);
		contentPane.add(cboProvedor);

		
		llenaCombo();
	}

	void llenaCombo() {
		
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//COMBO CATEGORIAS
		TypedQuery<Categorias> consulta =
				em.createQuery("select u from Categorias u",Categorias.class);
		
		List<Categorias> lstUsuarios = consulta.getResultList();
		
		cboCategorias.addItem("SELECCIONAR...");
        for (Categorias c : lstUsuarios) {
        cboCategorias.addItem(c.getDescripcion());
        		
        }
        //COMBO PROVEEDOR
        TypedQuery<Provedor> consulta2 =
				em.createQuery("select u from Provedor u",Provedor.class);
		
		List<Provedor> lstProveedor = consulta2.getResultList();
		
		cboProvedor.addItem("SELECCIONAR...");
        for (Provedor c : lstProveedor) {
        	cboProvedor.addItem(c.getNombre_rs());

        }
		em.close();
		
		
	}
	
	void listado() {
	
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			
		TypedQuery<Producto> consulta =
				em.createQuery("select u from Producto u",Producto.class);
		
		List<Producto> lstProducto = consulta.getResultList();
		
		txtSalida.setText("");
		for (Producto p : lstProducto) {
			txtSalida.append("codigo.......:" + p.getCodigo()+"\n");
			txtSalida.append("nombre.......:" + p.getDescripcion()+"\n");
			txtSalida.append("precio.......:" + p.getPrecio()+"\n");
			txtSalida.append("stock.......:" + p.getStock()+"\n");
			txtSalida.append("categoria....:" + p.getIdcategoria()+"\n");
			txtSalida.append("categoria....:" + p.getCategoria().getDescripcion()+"\n");
			txtSalida.append("provedor.....:" + p.getIdprovedor()+"\n");
			txtSalida.append("provedor.....:" + p.getProveedor().getNombre_rs()+"\n");
			txtSalida.append("***********************************\n");
			
			
			
			
		}
        
		
	}
	
	void registrar() {
		//ENTRADAS
		String idprod = txtCodigo.getText();
		String descripcion = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int categoria = cboCategorias.getSelectedIndex();
		int estado = 1;  //valor ppor default
		int proveedor = cboProvedor.getSelectedIndex();
		
		Producto p = new Producto();
		p.setCodigo(idprod);
		p.setDescripcion(descripcion);
		p.setStock(stock);
		p.setPrecio(precio);
		p.setIdcategoria(categoria);
		p.setEstado(estado);
		p.setIdprovedor(proveedor);
		
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
		
		JOptionPane.showMessageDialog(this,"PRODUCTO REGISTRADO...!");
		
		
		
		
		
		
		
		
		

	}
}
