package com.ibytecode.businesslogic;

import java.util.List;

import com.ibytecode.business.IProject;
import com.ibytecode.entities.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class ProjectBean
 */
@Stateless
public class ProjectBean implements IProject {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "JPADB")
    private EntityManager entityManager;
	
    public ProjectBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void saveProject(Project project) {
		// TODO Auto-generated method stub
		entityManager.persist(project);
	}

	@Override
	public Project findProject(Project project) {
		// TODO Auto-generated method stub
		Project p = entityManager.find(Project.class,
                project.getPnumber());
    return p;
	}

	@Override
	public List<Project> retrieveAllProjects() {
		// TODO Auto-generated method stub
		String q = "SELECT p from " + Project.class.getName() + " p";
        Query query = entityManager.createQuery(q);
        List<Project> projects = query.getResultList();
        return projects;
	}

}
