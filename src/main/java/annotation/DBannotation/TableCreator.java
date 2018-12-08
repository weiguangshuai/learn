package annotation.DBannotation;

import annotation.DBannotation.annotation.Constraints;
import annotation.DBannotation.annotation.DBTable;
import annotation.DBannotation.annotation.SQLInteger;
import annotation.DBannotation.annotation.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2018/12/7 0007
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("arguments: annotated classed");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class" + className);
                continue;
            }
            //获取表明，如果没有提供，则使用类名的大写作为表名
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toLowerCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                for (Annotation annotation : annotations) {
                    if (annotation instanceof SQLString) {
                        SQLString sqlString = (SQLString) annotation;
                        if (sqlString.name().length() < 1) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlString.name();
                        }
                        columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")"
                                + getConstraints(sqlString.constraints()));
                    }
                    if (annotation instanceof SQLInteger) {
                        SQLInteger sqlInteger = (SQLInteger) annotation;
                        if (sqlInteger.name().length() < 1) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlInteger.name();
                        }
                        columnDefs.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                    }
                }
            }
            StringBuilder createCommond = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommond.append("\n    " + columnDef + ",");
            }
            //经过遍历以后，字符串最后有个逗号，需要切掉
            String tableCreate = createCommond.substring(0, createCommond.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + "is :\n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints constraints) {
        String constraintStr = "";
        if (!constraints.allowNull()) {
            constraintStr += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            constraintStr += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            constraintStr += " UNIQUE";
        }
        return constraintStr;
    }
}
