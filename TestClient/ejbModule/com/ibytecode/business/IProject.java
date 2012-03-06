package com.ibytecode.business;
import java.util.List;

import javax.ejb.Remote;

import com.ibytecode.entities.Project;

@Remote
public interface IProject {
	void saveProject(Project project);
    Project findProject(Project project);
    List<Project> retrieveAllProjects();

}
