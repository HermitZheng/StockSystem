package beans;

import java.util.ArrayList;

public class DealCart {
    public ArrayList Deal(ArrayList sessionList, ArrayList requestList){
        if (sessionList == null){
            return requestList;
        }
        if (requestList == null){
            return sessionList;
        }
        for (int i = 0; i < sessionList.size(); i++) {
            Cart session = (Cart)sessionList.get(i);
            for (int j = 0; j < requestList.size(); j++) {
                Cart request = (Cart)requestList.get(j);
                if ((session.getStoId().equals(request.getStoId()))){
                    if ((session.getComId().equals(request.getComId()))) {
                        session.setQuantity(session.getQuantity() + request.getQuantity());
                        session.setTotalPrice(session.getTotalPrice() + request.getTotalPrice());
                        sessionList.remove(i);
                        sessionList.add(i, session);
                        requestList.remove(j);
                        requestList.add(j, null);
                        continue;
                    }
                }
            }
        }
        for (int i = 0; i < requestList.size(); i++) {
            Cart request = (Cart)requestList.get(i);
            if (request != null){
                sessionList.add(request);
            }
        }
        return sessionList;
    }
}
