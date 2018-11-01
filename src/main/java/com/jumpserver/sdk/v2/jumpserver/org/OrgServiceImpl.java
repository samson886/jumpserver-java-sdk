package com.jumpserver.sdk.v2.jumpserver.org;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.common.BaseJMSService;
import com.jumpserver.sdk.v2.common.ClientConstants;
import com.jumpserver.sdk.v2.model.Org;
import com.jumpserver.sdk.v2.model.OrgUsers;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class OrgServiceImpl extends BaseJMSService implements OrgService {

    @Override
    public List<Org> listOrg() {
        return get(Org.class, uri(ClientConstants.ORG)).executeList();
    }

    @Override
    public Org getOrg(String orgId) {
        checkNotNull(orgId);
        return get(Org.class, ClientConstants.ORG, orgId, "/").execute();
    }

    @Override
    public ActionResponse deleteOrg(String orgId) {
        checkNotNull(orgId);
        return deleteWithResponse(ClientConstants.ORG, orgId, "/").execute();
    }

    @Override
    public Org updateOrg(Org org) {
        checkNotNull(org);
        return patch(Org.class, ClientConstants.ORG, org.getId(), "/").json(JSON.toJSONString(org)).execute();
    }

    @Override
    public Org createOrg(Org org) {
        checkNotNull(org);
        return post(Org.class, uri(ClientConstants.ORG))
                .json(JSON.toJSONString(org))
                .execute();
    }

    @Override
    public OrgUsers getOrgUsers(String orgId) {
        checkNotNull(orgId);
        String url = ClientConstants.ORGUSERS.replace("{id}", orgId);
        return get(OrgUsers.class, url).execute();
    }

    @Override
    public OrgUsers createOrgUsers(OrgUsers orgusers) {
        checkNotNull(orgusers);
        String url = ClientConstants.ORGUSERS.replace("{id}", orgusers.getOrgId());
        return post(OrgUsers.class, url).json(JSON.toJSONString(orgusers)).execute();
    }

    @Override
    public OrgUsers updateOrgUsers(OrgUsers orgusers) {
        checkNotNull(orgusers);
        String url = ClientConstants.ORGUSERS.replace("{id}", orgusers.getOrgId());
        return patch(OrgUsers.class, url).json(JSON.toJSONString(orgusers)).execute();
    }

    @Override
    public OrgUsers getOrgAdmins(String orgId) {
        checkNotNull(orgId);
        String url = ClientConstants.ORGADMINS.replace("{id}", orgId);
        return get(OrgUsers.class, url).execute();
    }

    @Override
    public OrgUsers updateOrgAdmins(OrgUsers orgusers) {
        checkNotNull(orgusers);
        String url = ClientConstants.ORGADMINS.replace("{id}", orgusers.getOrgId());
        return patch(OrgUsers.class, url).json(JSON.toJSONString(orgusers)).execute();
    }

    @Override
    public OrgUsers createOrgAdmins(OrgUsers orgusers) {
        checkNotNull(orgusers);
        String url = ClientConstants.ORGADMINS.replace("{id}", orgusers.getOrgId());
        return post(OrgUsers.class, url).json(JSON.toJSONString(orgusers)).execute();
    }

}
