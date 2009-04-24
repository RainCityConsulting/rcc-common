package com.rcc.beans;

import java.util.Date;

public interface DateAuditable {
    public void setCreationDate(Date date);
    public Date getCreationDate();

    public void setLastUpdatedDate(Date date);
    public Date getLastUpdatedDate();
}
