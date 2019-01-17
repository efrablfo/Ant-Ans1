/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asn1.gui.custom;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author ewhite
 */
public class IconButton extends JButton{
    
    public IconButton(String iconName){  
        setBackground(Color.WHITE);
        URL url = getClass().getResource("icons/"+iconName) ;
        setIcon( new ImageIcon( url)  );
        setContentAreaFilled(false);
        setBorder( new LineBorder(Color.LIGHT_GRAY) );
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    @Override
        protected void paintComponent(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0), 
                    Color.WHITE, 
                    new Point(0, getHeight()), 
                    Color.WHITE));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }
}
