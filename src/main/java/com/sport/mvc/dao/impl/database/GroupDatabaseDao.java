package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.models.Group;
import org.springframework.stereotype.Repository;

@Repository(value = "groupDatabaseDao")
public class GroupDatabaseDao extends HibernateAbstractDao<Group> implements GroupDao {

    public GroupDatabaseDao() {
    }

   public void   saveToDBGroupIdANdStudentId(Long studentId, Long groupId){
       // now get a  session and start transaction
       getSession().beginTransaction();



      // Group mGroup = getSession().get(Group.class, getById(groupId));

       getSession().createQuery("INSERT INTO student_group(student_id) select studentId from student").executeUpdate();

       // commit the tranzaction
       getSession().getTransaction().commit();

       System.out.println("Done!");
   }
}
