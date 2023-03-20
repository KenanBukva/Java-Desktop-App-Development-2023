package six.gui.ui;

import six.gui.dao.Player;
import six.gui.dao.PlayerDao;
import six.gui.dao.Sport;
import six.gui.dao.SportDao;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.util.List;

/**
 *
 * <p> DB
 *     sports.players....ConnectionParam, ConnectionPool
 *     <li>Player</li>
 *     <li>PlayerDao implements Dao<Player></li>
 *     UI ili GUI
 *     <li>PlayerPanel</li>
 * </p>
 */
public class PlayerPanel extends JPanel {

    private List<Player> players;
    private List<Sport> sports;
    private final PlayerDao playerDao = new PlayerDao();
    private final SportDao sportDeo=new SportDao();
    public PlayerPanel(){
        super();
        this.sports=sportDeo.getAll();
        this.players = playerDao.getAll();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /**
         * JTable playerTable   <---- TABLE MODEL ----> PlayerDao
         *
         */
        PlayerTableModel playerTableModel = new PlayerTableModel();
        JTable playerTable = new JTable(playerTableModel);

        //SPORT
        TableColumn sportColumn = playerTable.getColumnModel().getColumn(3);
        JComboBox<String> sportComboBox = new JComboBox<>();
        sportColumn.setCellEditor(new DefaultCellEditor(sportComboBox));


        sports.stream()
                .map(Sport::getSport_name)
                .forEach(sportComboBox::addItem);

        JScrollPane playerTableScrollPane = new JScrollPane(playerTable);
        add(playerTableScrollPane);
    }


    private class PlayerTableModel extends AbstractTableModel{

        private List<String> columnNames;
        public PlayerTableModel(){
            this.columnNames = playerDao.getColumnNames();
        }

        @Override
        public int getRowCount() {
            return players.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Player player = players.get(rowIndex);

            PlayerWrapper playerWrapper = new PlayerWrapper(player);
            Object playerFieldOnIndex = playerWrapper.getColumValue(columnIndex);
            return playerFieldOnIndex;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Player player = players.get(rowIndex);
            PlayerWrapper playerWrapper = new PlayerWrapper(player);
            playerWrapper.setColumValue(columnIndex, aValue);
            playerDao.update(player);
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            return clazz;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex>0;
        }
    }
}
