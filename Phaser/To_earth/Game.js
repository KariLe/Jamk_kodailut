
BasicGame.Game = function (game) {

    //  When a State is added to Phaser it automatically has the following properties set on it, even if they already exist:

    this.game;      //  a reference to the currently running game (Phaser.Game)
    this.add;       //  used to add sprites, text, groups, etc (Phaser.GameObjectFactory)
    this.camera;    //  a reference to the game camera (Phaser.Camera)
    this.cache;     //  the game cache (Phaser.Cache)
    this.input;     //  the global input manager. You can access this.input.keyboard, this.input.mouse, as well from it. (Phaser.Input)
    this.load;      //  for preloading assets (Phaser.Loader)
    this.math;      //  lots of useful common math operations (Phaser.Math)
    this.sound;     //  the sound manager - add a sound, play one, set-up markers, etc (Phaser.SoundManager)
    this.stage;     //  the game stage (Phaser.Stage)
    this.time;      //  the clock (Phaser.Time)
    this.tweens;    //  the tween manager (Phaser.TweenManager)
    this.state;     //  the state manager (Phaser.StateManager)
    this.world;     //  the game world (Phaser.World)
    this.particles; //  the particle manager (Phaser.Particles)
    this.physics;   //  the physics manager (Phaser.Physics)
    this.rnd;       //  the repeatable random number generator (Phaser.RandomDataGenerator)

    //  You can use any of these from any function within this State.
    //  But do consider them as being 'reserved words', i.e. don't create a property for your own game called "world" or you'll over-write the world reference.

};

BasicGame.Game.prototype = {

    create: function () {

            	this.score = 0;
            	this.life = 3;
            
		this.stars = this.game.add.tileSprite(0, 0, 800, 970, 'layers', 'tahdet');
			//this.sky.scale.y = 1.25;//we scale sky a little higher
			//this.black = this.game.add.tileSprite(0, 970, 800, 120, 'layers', 'mustaa');
			this.ground = this.game.add.tileSprite(0, 2200, 800, 220, 'layers', 'maa');
           
            
            //
            this.game.world.setBounds(0, 0, 600, 2400);
            this.physics.startSystem(Phaser.Physics.P2JS);
            //this.physics.p2.setBoundsToWorld(true, false, false, true, false);
            this.physics.p2.gravity.y = 250;
            this.physics.p2.restitution = 0.4;
            
             //  Turn on impact events for the world, without this we get no collision callbacks
            this.physics.p2.setImpactEvents(true);
            
            //  Create our collision groups. One for the player, one for the meteors
            this.shipCollisionGroup = this.physics.p2.createCollisionGroup();
            this.meteorsCollisionGroup = this.physics.p2.createCollisionGroup();
            //  This part is vital if you want the objects with their own collision groups to still collide with the world bounds
            //  (which we do) - what this does is adjust the bounds to use its own collision group.
            this.shipCollisionGroup.collideWorldBounds = true;
            this.meteorsCollisionGroup.collideWorldBounds = false;
            
            var ships = this.add.group();   
            ships.enableBody = true; 
            
            //lisää spriten alukselle sheetistä alus
			
			
			
            this.ship = this.add.sprite(300, 2320, 'alus');
		
			this.ship.scale.setTo(0.5,0.5);
			
			
			//lisää animaatiot alukselle kaikissa kunnoissa
			this.ship.animations.add('lenna_life3',[1,2,3],false);
			this.ship.animations.add('lenna_life2',[8,9,10]);
			this.ship.animations.add('lenna_life1',[12,13,14]);
			this.ship.animations.add('lenna_life0',[17,18,19]);
            
            this.physics.p2.enable(this.ship, false);  
			
            //game.physics.enable(ship, Phaser.Physics.ARCADE);            
            this.ship.body.fixedRotation = false;
	
            this.ship.body.setCollisionGroup(this.shipCollisionGroup);
            //this.shipCollisionGroup.collideWorldBounds=true;
            //käskee kameran seuraamaan alusta
            this.camera.follow(this.ship);
            //luo nuolinäppäimet
            cursors = this.input.keyboard.createCursorKeys();
            
            //kameran collision
            //ship.body.setCircle(25);
            this.ship.body.collideWorldBounds = true;           
            //this.ship.body.setRectangle();
            
            //aluksen savuvana
            emitter = this.add.emitter(0, 0, 2000);
            emitter.makeParticles('smoke');         
           
            
            //attach smoke to ship
            this.ship.addChild(emitter);
            
            //position the emitter relative to the sprite's anchor location
            emitter.y = 45;
            emitter.x = -195;
            emitter.angle = -80;
            emitter.scale.setTo(0.5, 0.5);
            
            // setup options for the emitter
            emitter.lifespan = 500;
            emitter.maxParticleSpeed = new Phaser.Point(-100,50);
            emitter.minParticleSpeed = new Phaser.Point(-200,-50);            
           
            //Audio spritet
			//moottori
            fx = this.add.audio('moottori');			
            fx.allowMultiple = false;            
            fx.addMarker('moottori', 0, 2);
            fx.loop = false;
			//osuma kiveen
			fx2 = this.add.audio('osuma');
			fx2.allowMultiple = true;            
            fx2.addMarker('osuma', 0, 1);
            fx2.loop = false;
			//ikkuna hajoaa
			fx3 = this.add.audio('ikkuna_hajoaa');
			fx3.allowMultiple = true;            
            fx3.addMarker('ikkuna_hajoaa', 0, 1);
            fx3.loop = false;
			
            
            //pisteet
            this.pisteet_text = "Score ";
            this.pisteet_style = { font: "40px Impact", fill: "#ff1cdc"};            
            this.p = this.add.text(0, 0, this.pisteet_text + this.score, this.pisteet_style);
            this.p.fixedToCamera = true;
            
            //Elämät
            this.elamat_text = "Life ";
            this.elamat_style = { font: "40px Impact", fill: "#ff1cdc"};            
            this.e = this.add.text(0, 50, this.elamat_text + this.life, this.elamat_style);
            this.e.fixedToCamera = true;
            
           
            //meteors group
            var meteors = this.add.group();
            meteors.enableBody = true; 
            meteors.physicsBodyType = Phaser.Physics.P2JS;
            meteors.gravity = 0;
           
            
            for (var i = 0; i < 2; i++)
            {
                var meteor = meteors.create(i * 10, i* 150, 'kivi');
                //  Let gravity do its thing
                meteor.body.gravity.y = 0;
				meteor.body.setRectangle(100, 100, 0, 0);
                
                //  Tell the meteor to use the meteorsCollisionGroup 
                meteor.body.setCollisionGroup(this.meteorsCollisionGroup);
                meteor.body.collideWorldBounds=true;
                
                meteor.body.collides([this.meteorsCollisionGroup, this.shipCollisionGroup]);
				
				
            }
           
            
            this.physics.p2.updateBoundsCollisionGroup();
	
    },
    
    

    update: function () {

       
        this.ship.body.collides(this.meteorsCollisionGroup, hitMeteor, this);     

				
        function hitMeteor(body1, body2) {

            fx2.play('osuma',0,0.7,false,false); //osuman ääni 
	    body2.sprite.scale.setTo(0.8,0.8);
            body2.sprite.alpha -= 0.1;
            this.life -= 1;
			
			//kun kivi osuu alukseen, säädetään alphaa, kokoa ja muutetaan framea molemmissa
			body2.sprite.frame = this.game.rnd.integerInRange(1, 2);
		
			
			
			
            console.log(this.life);
            this.e.text = 'Life ' + this.life;
				
            if(this.life <= 0)
            {
				fx3.play('ikkuna_hajoaa',0,1.2,false,false); //osuman ääni 
                this.ship.kill();
				//vaihdetaan että tulee game over ja score
                this.state.start('GameOver');
            }
			
        }
		
		

		
        if (cursors.left.isDown)
        {
            this.ship.body.rotateLeft(50);
         
        }    
        else if (cursors.right.isDown)
        {
            this.ship.body.rotateRight(50);
            
        }
        else //jotta alus ei jatka pyörimistä itsekseen
        {
            this.ship.body.setZeroRotation();
        }  
		
        if (cursors.up.isDown)
        {
            this.ship.animations.play('lenna_life3', 30, false);
            this.ship.body.thrust(400);            
            //fx.play('ignition',0,0.1,false,false); //raketin ääni
            
            //savuttaa            
            emitter.emitParticle();
            //ship.body.velocity.y = -200;
            //ship.y -= 4;
        }
        else if (cursors.down.isDown)
        {
			this.ship.animations.play('lenna_life3', 30, false);
            this.ship.body.thrust(400);            
            //fx.play('ignition',0,0.1,false,false); //raketin ääni
            
            //savuttaa            
            emitter.emitParticle();
        }	
        else if(this.input.mousePointer.isDown)
        {
			this.ship.animations.play('lenna_life3', 30, false);
            this.ship.body.rotation = this.physics.arcade.angleToPointer(this.ship) - Math.PI/2;
            this.ship.body.thrust(400); 
            fx.play('moottori',0,0.5,false,false); //raketin ääni       
            
            //savuttaa            
            emitter.emitParticle();
            
            if (Phaser.Rectangle.contains(this.ship.body, this.input.x, this.input.y))
            {
                this.ship.body.velocity.setTo(0, 0);
            }
        }
		else
		{
			fx.stop('moottori');
			this.ship.frame = 0;
		}
        
         
		//kosketusnäytölle
	
		if(this.input.pointer1.isDown)
        {
			this.ship.animations.play('lenna_life3', 30, false);
            this.ship.body.rotation = this.physics.arcade.angleToPointer(this.ship) - Math.PI/2;
            this.ship.body.thrust(400); 
            fx.play('moottori',0,0.5,false,false); //raketin ääni       
            
            //savuttaa            
            emitter.emitParticle();
            
            if (Phaser.Rectangle.contains(this.ship.body, this.input.x, this.input.y))
            {
                this.ship.body.velocity.setTo(0, 0);
            }
		}
              
        
          
        

    },
    
    render: function() {
	
		if(this.life == 3)
			{
			this.ship.frame= 0;
			}
			else if(this.life == 2)
			{
			this.ship.frame = 4;
			}
			else if(this.life == 1)
			{
			this.ship.frame = 5;
			}
			else if(this.life === 0)
			{
			this.ship.frame = 6;
			}	
			
			
		
		
    },    
  

    quitGame: function (pointer) {

    }

};

