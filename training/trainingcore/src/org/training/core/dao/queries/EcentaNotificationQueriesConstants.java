package org.training.core.dao.queries;

import org.training.core.model.EcentaNotificationModel;

public final class EcentaNotificationQueriesConstants {
    private EcentaNotificationQueriesConstants() {
    }

    public final static String SELECT_ECENTA_NOTIF_CLAUSE = "SELECT {"
            + EcentaNotificationModel.PK
            + "} ";

    public final static String FROM_ECENTA_NOTIF_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + "} ";

    public final static String FROM_ECENTA_NOTIF_JOIN_PRIORITY_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + " JOIN NotificationPriorityEnum ON {"
            + EcentaNotificationModel.PRIORITY
            + "} = {NotificationPriorityEnum.PK}} ";

    public final static String FROM_ECENTA_NOTIF_JOIN_TYPE_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + " JOIN NotificationTypeEnum ON {"
            + EcentaNotificationModel.TYPE
            + "} = {NotificationTypeEnum.PK}} ";

    public final static String OLD_ECENTA_NOTIF_CLAUSE = "{"
            + EcentaNotificationModel.DATE
            + "} <= ?oldDate";

    public final static String SELECT_OLD_ECENTA_NOTIF = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_TABLE
            + "WHERE "
            + OLD_ECENTA_NOTIF_CLAUSE;

    public final static String B2BCUSTOMER_CLAUSE = "{"
            + EcentaNotificationModel.B2BCUSTOMER
            + "} = ?b2BCustomer ";

    public final static String PRIORITY_CODE_CLAUSE = "{NotificationPriorityEnum.CODE} = ?priority ";

    public final static String TYPE_CODE_CLAUSE = " {NotificationTypeEnum.CODE} = ?type ";

    public final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_TABLE
            + "WHERE "
            + B2BCUSTOMER_CLAUSE;

    public final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_PRIORITY = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_JOIN_PRIORITY_TABLE
            + "WHERE "
            + PRIORITY_CODE_CLAUSE
            + "AND "
            + B2BCUSTOMER_CLAUSE;

    public final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_TYPE = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_JOIN_TYPE_TABLE
            + "WHERE "
            + TYPE_CODE_CLAUSE
            + "AND "
            + B2BCUSTOMER_CLAUSE;

    public final static String SELECT_ONE_ECENTA_NOTIF = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_TABLE
            + "WHERE {"
            + EcentaNotificationModel.ID
            + "} = 1 ";
}