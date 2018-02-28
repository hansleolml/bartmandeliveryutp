package pe.edu.utp.barmandelivery.beans;


import pe.edu.utp.barmandelivery.models.BarService;
import pe.edu.utp.barmandelivery.models.Contract;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ContractsBean implements Serializable {

    private BarService service;
    private Contract contract;

    public ContractsBean(){
        service= new BarService();
    }

    public List<Contract> getContracts(){

        return service.findAllContracts();
    }
    public Contract getContract(){
        return contract;
    }

    public void setContract(Contract contract){
        this.contract =contract;
    }

    public String newContract(){
        this.setContract(new Contract());
        return "success";
    }

    public String editContract(Contract contract){
        this.setContract(contract);
        return "success";
    }

    public String contractContract(Contract contract){
        //service.updateContract(this.getContract());
        return "success";
    }


}
