package com.aemsitetest.core.services.impl;

import com.aemsitetest.core.services.CompareTitle;
import org.osgi.service.component.annotations.Component;

@Component(
        service = CompareTitle.class,
        immediate = true)
public class CompareTitleImpl implements CompareTitle {

    public String compareTitleToPathAndAddResult(String titlePath, String path){
        int pathLength = path.length();
        int titleLength = titlePath.length() - pathLength;
        String newTitle = titlePath;
        if(titleLength > pathLength){
            newTitle = newTitle + " title is longer";
        } else if (titleLength < pathLength){
            newTitle = newTitle + " path is longer";
        }else{
            newTitle = newTitle + " title and path are equal";
        }
    return newTitle;
    }
}