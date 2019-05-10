package br.com.nuclearis.integration.viewer.implementations;

import org.springframework.stereotype.Service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

import br.com.nuclearis.integration.viewer.model.Informations;
import br.com.nuclearis.integration.viewer.services.IntegrationService;

@Service
public class IntegrationServiceImpl implements IntegrationService {

	public boolean executeViewer(Informations informations) {
		if (informations.getLogin() != null && informations.getPassword() != null && informations.getCdAccess() != null) {

			ActiveXComponent dll = new ActiveXComponent("CSHRisIntegration.CSHRisIntegration");
			Dispatch.call(dll, "Init");
			Dispatch.call(dll, "Login", informations.getLogin(), informations.getPassword(), 0);
			Dispatch.call(dll, "ShowStudy", informations.getCdAccess(), "");

			return true;
		}

		return false;
	}
}
