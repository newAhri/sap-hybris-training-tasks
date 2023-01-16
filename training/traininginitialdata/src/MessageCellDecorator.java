import de.hybris.platform.util.CSVCellDecorator;
import java.util.Map;

public class MessageCellDecorator implements CSVCellDecorator {
    @Override
    public String decorate(final int position, final Map<Integer, String> srcLine) {
        String csvCell = srcLine.get(position);
        if (csvCell != null && csvCell.length() != 0) {
            csvCell.concat("\nHave a great day!");
        }
        return csvCell;
    }
}
