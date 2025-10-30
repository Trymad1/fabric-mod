package com.trymad.screen;

import com.trymad.model.MessageProto;
import com.trymad.network.ClientModNetwork;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;


@Environment(EnvType.CLIENT)
public class TextFieldGuiDescription extends LightweightGuiDescription {
	
	public TextFieldGuiDescription() {
        final WGridPanel root = new WGridPanel();
        final WTextField textField = new WTextField();
        final WButton sendButton = new WButton(Component.literal("Отправить"));

		textField.setSuggestion(Component.literal("Hello world?"));
		textField.setMaxLength(256);

		sendButton.setOnClick(() -> {
			final MessageProto.Message message = MessageProto.Message.newBuilder()
					.setText(textField.getText())
					.build();

			ClientModNetwork.send(message);
		});


        setRootPanel(root);

        root.setSize(200, 80);
        root.add(textField, 1, 1, 9, 1); 
        root.add(sendButton, 3, 3, 5, 1);

        root.validate(this);
	}
}
