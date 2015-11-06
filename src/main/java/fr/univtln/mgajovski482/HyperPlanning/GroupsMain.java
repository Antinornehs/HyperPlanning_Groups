package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormation;
import fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormationGenerator.GroupInFormationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Maxime on 06/11/2015.
 */
public class GroupsMain {

    private static Logger logger = Logger.getLogger("GroupsMain.class");

    private static volatile GroupsMain _instance = null;

    public GroupsMain(){

        GroupInFormationGenerator.generateGroups(Consts.GROUPS_TO_GENERATE);
        logger.info("Groups Package Initialized !");
    }

    public static GroupsMain getInstance() throws Exception {
        if(_instance == null) {
            synchronized (GroupsMain.class) {
                if (_instance == null) {
                    _instance = new GroupsMain();
                }
            }
        }
        return _instance;
    }
}

