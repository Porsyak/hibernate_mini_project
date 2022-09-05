
import dao.CommonDAO;
import dao.Impl.RoleDAOImpl;
import dao.Impl.UserDAOImp;
import dao.interfeses.UserDAO;
import entity.Role;
import entity.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        roleDAO.delete();



    }
}




